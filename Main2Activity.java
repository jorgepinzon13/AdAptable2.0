package com.example.jorge.adaptable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    String username,email;
    Intent intent;
    ImageView bBusq,bPerfil,bUbi,bConf;
    TextView bAdaptable;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();


        bBusq = (ImageView) findViewById(R.id.bBusq);
        bPerfil = (ImageView) findViewById(R.id.bPerfil);
        bUbi = (ImageView) findViewById(R.id.bUbi);
        bConf = (ImageView) findViewById(R.id.bConf);
        bAdaptable = (TextView) findViewById(R.id.bAdaptable);

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        email = extras.getString("email");

        bBusq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Search2Activity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });


        bPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Perfil2Activity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });


        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, MapsActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });


        bConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Main2Activity.this, Settings2Activity.class);
                intent.putExtra("username",username);
                intent.putExtra("email",email);
                startActivity(intent);
                finish();
            }
        });



    }
}
