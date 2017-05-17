package com.jonmid.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap m_map;
    boolean mapReady = false;


    static final CameraPosition PASTO = CameraPosition.builder()
            .target(new LatLng(1.2089284,-77.2779443))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204,-122.3491))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();


    static final CameraPosition DUBLIN = CameraPosition.builder()
            .target(new LatLng(53.3478,-6.2597))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    static final CameraPosition TOKYO = CameraPosition.builder()
            .target(new LatLng(35.6895,139.6917))
            .zoom(15)
            .bearing(90)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnseatle = (Button) findViewById(R.id.id_btn_seattle);
        btnseatle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ciudad(SEATTLE);


            }
        });

        Button btndublin = (Button) findViewById(R.id.id_btn_dublin);
        btndublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ciudad(DUBLIN);

            }
        });

        Button btntokio = (Button) findViewById(R.id.id_btn_tokio);
        btntokio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ciudad(TOKYO);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
        ciudad(PASTO);

    }
public void ciudad(CameraPosition city){
    m_map.animateCamera(CameraUpdateFactory.newCameraPosition(city),10000,null);
}

}
