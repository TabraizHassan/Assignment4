
package com.example.assignment1;

import java.util.List;

public class Daily {

    private Double dt;
    private Double sunrise;
    private Double sunset;


    private Double dewPoint;
    private Double windSpeed;

    private Double pressure;
    private Double humidity;

    private Double windDegree;
    private Double clouds;
    private Double uvi;
    private Double pop;

    private Double rain;



    private Temperature temperature;
    private FeelLike feels_like;
    private List<Weather> weather = null;



    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
    public List<Weather> getWeather() {
        return weather;
    }







    public void setDt(Double dt) {

        this.dt = dt;
    }
    public Double getDt() {

        return dt;
    }




    public void setSunrise(Double sunrise) {

        this.sunrise = sunrise;
    }
    public Double getSunrise() {

        return sunrise;
    }




    public void setSunset(Double sunset) {
        this.sunset = sunset;
    }
    public Double getSunset() {
        return sunset;
    }



    public void setTemperature(Temperature temperature) {

        this.temperature = temperature;
    }
    public Temperature getTemperature() {
        return temperature;
    }




    public void setFeelsLike(FeelLike feelLike) {

        this.feels_like = feelLike;
    }
    public FeelLike getFeelsLike() {
        return feels_like; }



    public void setPressure(Double pressure) {

        this.pressure = pressure;
    }
    public Double getPressure() {

        return pressure;
    }



    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
    public Double getHumidity() {
        return humidity;
    }


    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }
    public Double getDewPoint() {
        return dewPoint;
    }


    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }
    public Double getWindSpeed() {

        return windSpeed;
    }


    public void setWindDeg(Double windDeg) {

        this.windDegree = windDeg;
    }
    public Double getWindDeg() {

        return windDegree;
    }



    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }
    public Double getClouds() {

        return clouds;
    }


    public void setPop(Double pop) {

        this.pop = pop;
    }
    public Double getPop() {
        return pop;
    }



    public void setUvi(Double uvi) {

        this.uvi = uvi;
    }
    public Double getUvi() {

        return uvi;
    }


    public void setRain(Double rain) {

        this.rain = rain;
    }
    public Double getRain() {

        return rain;
    }



}
