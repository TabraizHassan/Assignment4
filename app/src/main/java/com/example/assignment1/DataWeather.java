
package com.example.assignment1;

import java.util.List;

public class DataWeather {

    private Double lat;
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLat() {

        return lat;
    }


    private Double lon;
    public void setLon(Double lon) {
        this.lon = lon;
    }
    public Double getLon() {
        return lon;
    }



    private List<Daily> daily = null;
    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public List<Daily> getDaily() {
        return daily;
    }









}
