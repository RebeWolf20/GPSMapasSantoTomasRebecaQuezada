package com.example.rebecaquezada;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ubicacion extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        txtLatitud = findViewById(R.id.et_lat);
        txtLongitud = findViewById(R.id.et_long);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap){
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        Sede("Santo Tomás Arica", -18.4833856, -70.3103754);
        Sede("Santo Tomás Iquique", -20.2397762, -70.1448787);
        Sede("Santo Tomás Antofagasta", -23.6347315, -70.3940526);
        Sede("Santo Tomás La Serena", -29.9051257, -71.2638824);
        Sede("Santo Tomás Viña del Mar", -33.4489738, -70.6607805);
        Sede("Santo Tomás Santiago", -35.4287087, -71.672915);
        Sede("Santo Tomás Talca", -36.8265352, -73.0639887);
        Sede("Santo Tomás Concepción", -37.4720562, -72.3539949);
        Sede("Santo Tomás Los Ángeles", -38.7391658, -72.5969291);
        Sede("Santo Tomás Temuco", -38.7391658, -72.5969291);
        Sede("Santo Tomás Valdivia", -39.8174169, -73.2331328);
        Sede("Santo Tomás Osorno", -40.5717908, -73.1377152);
        Sede("Santo Tomás Puerto Montt", -38.7391658, -72.5969291);

    }
    private void Sede(String title, double latitude, double longitude) {
        LatLng ubiSedes = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(ubiSedes).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubiSedes));
    }
    @Override
    public void onMapClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latLng){
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }
    public void ust2024(View view){
        Intent admi = new Intent(this, VideoUST.class);
        startActivity(admi);

    }
}