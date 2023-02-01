package com.example.googlemaps2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener{

        GoogleMap Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Mapa = googleMap;
        Mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        Mapa.getUiSettings().setZoomControlsEnabled(true);
        Mapa.getUiSettings().setMyLocationButtonEnabled(true);
        Mapa.getUiSettings().setMapToolbarEnabled(true);

        CameraUpdate camUpd1 = CameraUpdateFactory.newLatLngZoom(new LatLng(25.26372762376248, 51.44837162622351), 15);
        Mapa.moveCamera(camUpd1);
        LatLng madrid = new LatLng(25.26372762376248, -51.44837162622351);

      /*CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)
                .zoom(19)
                .bearing(45)      //noreste arriba
                .tilt(70)         //punto de vista de la cámara 70 grados
                .build();

        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);

        Mapa.animateCamera(camUpd3);*/

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        Projection proj = Mapa.getProjection();
        Point coord = proj.toScreenLocation(latLng);

        Toast.makeText(
                MainActivity.this,
                "Click\n" +
                "Lat: " + latLng.latitude + "\n" +
                "Lng: " + latLng.longitude + "\n" +
                "X: " + coord.x + " - Y: " + coord.y,
                Toast.LENGTH_SHORT).show();

    }
}