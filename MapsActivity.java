package com.example.jorge.adaptable;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String username, email;
    Intent intent;
    ImageView bBusq, bPerfil, bUbi, bConf;
    TextView bAdaptable;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor = prefs.edit();


        bBusq = (ImageView) findViewById(R.id.bBusq);
        bPerfil = (ImageView) findViewById(R.id.bPerfil);
        bUbi = (ImageView) findViewById(R.id.bUbi);
        bConf = (ImageView) findViewById(R.id.bConf);
        bAdaptable = (TextView) findViewById(R.id.bAdaptable);

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        email = extras.getString("email");

        bAdaptable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

        bBusq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, Search2Activity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });


        bPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, Perfil2Activity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });


        bConf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapsActivity.this, Settings2Activity.class);
                intent.putExtra("username", username);
                intent.putExtra("email", email);
                startActivity(intent);
                finish();
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng Medellin = new LatLng(6.250248, -75.567944);
        mMap.addMarker(new MarkerOptions().position(Medellin).visible(false));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Medellin,13));

        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.adp100);

        LatLng Udea = new LatLng(6.266953, -75.569111);
        mMap.addMarker(new MarkerOptions().position(Udea).title("Marker in Udea").snippet("Universidad de Antioquia").icon(icon));

        LatLng molinos = new LatLng(6.233170, -75.604180);
        mMap.addMarker(new MarkerOptions().position(molinos).title("Marker in Molinos").snippet("Centro Comercial Los Molinos").icon(icon));

        LatLng unicentro = new LatLng(6.241259, -75.587662);
        mMap.addMarker(new MarkerOptions().position(unicentro).title("Marker in Unicentro").snippet("Centro Comercial Unicentro").icon(icon));

        LatLng santafe = new LatLng(6.196633, -75.574079);
        mMap.addMarker(new MarkerOptions().position(santafe).title("Marker in Santafe").snippet("Centro Comercial Santafé").icon(icon));

        LatLng oviedo = new LatLng(6.199257, -75.575330);
        mMap.addMarker(new MarkerOptions().position(oviedo).title("Marker in Oviedo").snippet("Centro Comercial Oviedo  ").icon(icon));

        LatLng premiumplaza = new LatLng(6.229237, -75.570541);
        mMap.addMarker(new MarkerOptions().position(premiumplaza).title("Marker in Premium Plaza").snippet("Centro Comercial Premium Plaza").icon(icon));

        LatLng aventura = new LatLng(6.264184, -75.567037);
        mMap.addMarker(new MarkerOptions().position(aventura).title("Marker in Aventura").snippet("Centro Comercial Aventura").icon(icon));

        LatLng bosque = new LatLng(6.268841, -75.565256);
        mMap.addMarker(new MarkerOptions().position(bosque).title("Marker in Bosque Plaza").snippet("Centro Comercial Bosque Plaza").icon(icon));

        LatLng elhueco = new LatLng(6.248903, -75.571423);
        mMap.addMarker(new MarkerOptions().position(elhueco).title("Marker in El hueco").snippet("Japón El Hueco").icon(icon));

        LatLng mayorca = new LatLng(6.160481, -75.604654);
        mMap.addMarker(new MarkerOptions().position(mayorca).title("Marker in Mayorca").snippet("Centro Comercial Mayorca").icon(icon));

        LatLng puertanorte = new LatLng(6.339446, -75.543526);
        mMap.addMarker(new MarkerOptions().position(puertanorte).title("Marker in Puerta del Norte").snippet("Centro Comercial Puerta del Norte").icon(icon));

        LatLng tesoro = new LatLng(6.197312, -75.558936);
        mMap.addMarker(new MarkerOptions().position(tesoro).title("Marker in El Tesoro").snippet("Parque Comercial El Tesoro").icon(icon));

        LatLng sandiego = new LatLng(6.235599, -75.569576);
        mMap.addMarker(new MarkerOptions().position(sandiego).title("Marker in San Diego").snippet("Centro Comercial San Diego").icon(icon));

    }
}
