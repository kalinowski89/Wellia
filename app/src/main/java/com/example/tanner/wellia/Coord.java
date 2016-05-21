package com.example.tanner.wellia;

/**
 * Created by tanner on 5/21/16.
 */
public class Coord {
    double lat,lng;
    public Coord(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
