package com.example.jorge.adaptable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {


    EditText eUsuario2,ePassword2, eReppass,eEmail;
    Button bReg,bCan;
    String usuario,password,correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsuario2=(EditText)findViewById(R.id.eUsuario2);
        ePassword2=(EditText)findViewById(R.id.ePassword2);
        eReppass=(EditText)findViewById(R.id.eReppass);
        eEmail=(EditText)findViewById(R.id.eEmail);
        bReg=(Button) findViewById(R.id.bReg);
        bCan=(Button) findViewById(R.id.bCan);


        bCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegistroActivity.this, LoginActivity.class);
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });


        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!eUsuario2.getText().toString().equals("") && !ePassword2.getText().toString().equals("") && !eReppass.getText().toString().equals("") && !eEmail.getText().toString().equals("")) {

                    if (eReppass.getText().toString().equals(ePassword2.getText().toString())) {


                        Intent intent = new Intent();
                        intent.putExtra("username", eUsuario2.getText().toString());
                        intent.putExtra("password", ePassword2.getText().toString());
                        intent.putExtra("email", eEmail.getText().toString());
                        setResult(RESULT_OK, intent);
                        finish();

                    }
                    else {

                        Toast.makeText(getApplicationContext(),getResources().getString(R.string.ToastPass),Toast.LENGTH_SHORT).show();

                    }
                }
                else {

                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.ToastCampos),Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
}
