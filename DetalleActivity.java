package com.example.jorge.adaptable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetalleActivity extends AppCompatActivity {

    public static final String EXTRA_PARAM_ID = "com.herprogramacion.Promos2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Promo itemDetallado;
    private ImageView imagenExtendida;
    String id;
    Intent intent;
    ImageView bBusq,bPerfil,bUbi,bConf;
    TextView bAdaptable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        //usarToolbar();

        // Obtener el Promo con el identificador establecido en la actividad principal
        itemDetallado = Promo.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        imagenExtendida = (ImageView) findViewById(R.id.imagen_extendida);

        cargarImagenExtendida();

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
                Intent intent= new Intent(DetalleActivity.this, MainActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

        bBusq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetalleActivity.this, Search2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetalleActivity.this, Perfil2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetalleActivity.this, MapsActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });


        bConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DetalleActivity.this, Settings2Activity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
                finish();
            }
        });

    }

    private void cargarImagenExtendida() {
        Glide.with(imagenExtendida.getContext())
                .load(itemDetallado.getIdDrawable())
                .into(imagenExtendida);
    }
/*
    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }*/
}
