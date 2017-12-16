package com.example.moraga.ev4vmoragaptenorio;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final String Lat="LATI";
    public static final String Long="LONG";
    public static final String Desc="Dir";
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng globus = new LatLng(-53.157592,-70.9038297);
        LatLng jorescom = new LatLng(-53.1608407,-70.9044775);
        LatLng sisinf = new LatLng(-53.1603378,-70.9138951);
        mMap.addMarker(new MarkerOptions().position(globus).title("GLOBUS COMPUTACION"));
        mMap.addMarker(new MarkerOptions().position(jorescom).title("JORESCOM LTDA."));
        mMap.addMarker(new MarkerOptions().position(sisinf).title("SISTEMAS INFORMATICOS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(globus));
    }
}
