package com.example.tanner.wellia;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by tanner on 5/22/16.
 */
public class LocListener implements LocationListener {
    LatLng cam = null;
    GoogleMap mMap;
    Location loc;
    public LocListener() {

    }

    public void setmMap(GoogleMap mMap) {
        this.mMap = mMap;
    }

    public Location getLoc() {
        return loc;
    }

    @Override
    public void onLocationChanged(Location location) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(location.getLatitude(),location.getLongitude()))      // Sets the center of the map to Mountain View
                    .zoom(10)                   // Sets the zoom
                    .build();                   // Creates a CameraPosition from the builder
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            System.out.println(location.toString());
            loc=location;


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
