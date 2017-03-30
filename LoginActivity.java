package com.example.jorge.adaptable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    EditText eUsuario,ePassword;
    Button bInicio;
    TextView tReg;
    String username="", password="",email="";

    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();


        eUsuario=(EditText)findViewById(R.id.eUsuario);
        ePassword=(EditText)findViewById(R.id.ePassword);
        bInicio=(Button) findViewById(R.id.bInicio);
        tReg=(TextView) findViewById(R.id.tReg);

        username = prefs.getString("username","");
        password = prefs.getString("password","");
        email = prefs.getString("email","");

        if (prefs.getInt("login",-1)==1){
            Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            intent.putExtra("email", email);

            startActivity(intent);


        }


        Bundle extras = getIntent().getExtras();


        bInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!eUsuario.getText().toString().equals("") && !ePassword.getText().toString().equals("")) {

                    if (eUsuario.getText().toString().equals(username) && ePassword.getText().toString().equals(password)) {

                        editor.putInt("login",1); //1 significa alguien loggeado 0 sin loggear
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("password", password);
                        intent.putExtra("email", email);

                        startActivity(intent);
                        //                    finish();
                    } else {

                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.ToastUser), Toast.LENGTH_SHORT).show();

                    }

                } else {

                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.ToastCampos), Toast.LENGTH_SHORT).show();

                }
            }

        });

        tReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){

            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            email = data.getExtras().getString("email");
            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("email",email);


        }

        if (requestCode==1234 && resultCode== RESULT_CANCELED){

            Toast.makeText(this,getResources().getString(R.string.ToastErrorReg),Toast.LENGTH_SHORT).show();
        }
    }
}
