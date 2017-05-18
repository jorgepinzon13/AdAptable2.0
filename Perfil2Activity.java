package com.example.jorge.adaptable;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class Perfil2Activity extends AppCompatActivity {

    String username,id;
    Uri photoUrl;
    Intent intent;
    TextView eUsuarioP, bAdaptable;
    ImageView bBusq,bPerfil,bUbi,bConf,bLogOut,iPerfil;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil2);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        photoUrl = user.getPhotoUrl();
        username = user.getDisplayName();

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        bBusq = (ImageView) findViewById(R.id.bBusq);
        bPerfil = (ImageView) findViewById(R.id.bPerfil);
        bUbi = (ImageView) findViewById(R.id.bUbi);
        bConf = (ImageView) findViewById(R.id.bConf);
        bLogOut = (ImageView) findViewById(R.id.bLogOut);
        bAdaptable = (TextView) findViewById(R.id.bAdaptable);
        iPerfil = (ImageView) findViewById(R.id.iPerfil);

        Bundle extras = getIntent().getExtras();
        id = extras.getString("ID");


        Picasso.with(this).load(photoUrl).into(iPerfil);


        eUsuarioP = (TextView) findViewById(R.id.eUsuarioP);
        eUsuarioP.setText(username);


        bAdaptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Perfil2Activity.this, MainActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

        bBusq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Perfil2Activity.this, Search2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Perfil2Activity.this, MapsActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Perfil2Activity.this, Settings2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                FirebaseAuth.getInstance().signOut();
                goMainActivity();
                finish();
            }
        });


    }




    private void goMainActivity() {
        Intent intent = new Intent (Perfil2Activity.this, LoginActivity.class);
        startActivity(intent);
    }

}
