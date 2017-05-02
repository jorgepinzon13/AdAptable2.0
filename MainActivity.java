package com.example.jorge.adaptable;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
  implements AdapterView.OnItemClickListener {
        private GridView gridView;
        private AdaptadordePromos adaptador;

        String username,email;
        Intent intent;
        ImageView bBusq,bPerfil,bUbi,bConf;
        TextView bAdaptable;
        SharedPreferences prefs;
        SharedPreferences.Editor editor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            gridView = (GridView) findViewById(R.id.grid);
            adaptador = new AdaptadordePromos(this);
            gridView.setAdapter(adaptador);
            gridView.setOnItemClickListener(this);

            prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
            editor = prefs.edit();

            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {

                } else {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

                }
            }

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
                    Intent intent= new Intent(MainActivity.this, Search2Activity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                }
            });


            bPerfil.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(MainActivity.this, Perfil2Activity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                }
            });


            bUbi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                }
            });


            bConf.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(MainActivity.this, Settings2Activity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                }
            });




        }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1 ;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Promo item = (Promo) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, DetalleActivity.class);
        intent.putExtra(DetalleActivity.EXTRA_PARAM_ID, item.getId());
        startActivity(intent);
    }
}
