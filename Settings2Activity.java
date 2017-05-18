package com.example.jorge.adaptable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Settings2Activity extends AppCompatActivity {

    String id;
    Intent intent;
    ImageView bBusq,bPerfil,bUbi,bConf;
    TextView bAdaptable;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    Switch s1,s2,s3;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        s1=(Switch) findViewById(R.id.s1);
        s2=(Switch) findViewById(R.id.s2);
        s3=(Switch) findViewById(R.id.s3);

        cb1=(CheckBox) findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);
        cb6=(CheckBox)findViewById(R.id.cb6);
        cb7=(CheckBox)findViewById(R.id.cb7);
        cb8=(CheckBox)findViewById(R.id.cb8);

        bBusq = (ImageView) findViewById(R.id.bBusq);
        bPerfil = (ImageView) findViewById(R.id.bPerfil);
        bUbi = (ImageView) findViewById(R.id.bUbi);
        bConf = (ImageView) findViewById(R.id.bConf);
        bAdaptable = (TextView) findViewById(R.id.bAdaptable);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("ID");

        bAdaptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settings2Activity.this, MainActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

        bBusq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settings2Activity.this, Search2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settings2Activity.this, Perfil2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Settings2Activity.this, MapsActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


    }

    public void Clicked (View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case R.id.cb1:
                break;

            case R.id.cb2:
                break;

            case R.id.cb3:
                break;

            case R.id.cb4:
                break;

            case R.id.cb5:
                break;

            case R.id.cb6:
                break;

            case R.id.cb7:
                break;

            case R.id.cb8:
                break;
        }
    }


}
