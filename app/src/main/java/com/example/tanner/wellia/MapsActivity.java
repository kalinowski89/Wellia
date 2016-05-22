package com.example.tanner.wellia;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.Button;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // create the Filter button
        Button filter = (Button) findViewById(R.id.filter);
        // create the List View button
        Button list_view = (Button) findViewById(R.id.list_view);

        if (filter != null) {
            filter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setContentView(R.layout.activity_main);
                    System.out.println("clicked");
                    Class mapsActivityClass = null;
                    try {
                        mapsActivityClass = Class.forName("com.example.tanner.wellia.MainActivity");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    Intent myIntent = new Intent(MapsActivity.this,mapsActivityClass);
                    startActivity(myIntent);
                    finish();

                }
            });
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        mMap = googleMap;

        double user_lat=50.0,user_lng=50.0;
        ArrayList<Coord> locations = new ArrayList<>();

        // center the camera around the user's location
        LatLng user_location = new LatLng(user_lat, user_lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(user_location));
        JSONArray ja=null;
        try {
            ja = new dataParse().parseData();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // loop through the data and set a marker at each lat and long
        if (ja != null) {
            for (int i = 0; i < ja.length(); i++) {
                // create a new marker
                try {
                    JSONObject tmp = (JSONObject)(ja.get(i));
                    System.out.println();
                    LatLng new_loc = new LatLng(tmp.getDouble("LAT"),tmp.getDouble("LNG"));
                    mMap.addMarker(new MarkerOptions().position(new_loc).title(tmp.getString("NAME1")));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
