package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class WeatherActivity extends AppCompatActivity {

    ImageView imageView;
    TextView desc;
    TextView temp;
    TextView FeelLike;
    TextView sunset;
    TextView sunrise;
    TextView pressure;
    TextView humidity;
    TextView windspeed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutweather);


        imageView = findViewById(R.id.bigimage);
        desc = findViewById(R.id.description);
        temp = findViewById(R.id.temperature);
        FeelLike = findViewById(R.id.feels_like);

        pressure = findViewById(R.id.pressureval);
        windspeed = findViewById(R.id.windspeed);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);


        humidity = findViewById(R.id.humidityval);






        Intent intent = getIntent();
        Double Temp = intent.getDoubleExtra("Temp",10);
        String Description = intent.getStringExtra("Description");
        Double Feel_like = intent.getDoubleExtra("Feels Like", 10);
        String ImageURL = intent.getStringExtra("ImageURL");
        Integer Pressure = intent.getIntExtra("Pressure",10);
        Integer Humidity = intent.getIntExtra("Humidity",10);
        Integer Sunrise = intent.getIntExtra("Sunrise",10);
        Integer Sunset = intent.getIntExtra("Sunset",10);

        Double WindSpeed = intent.getDoubleExtra("Wind",10);




        Glide.with(this).load(ImageURL).fitCenter().into(imageView);
        desc.setText(Description);
        FeelLike.setText("Feels like: "+Feel_like+" C");
        temp.setText(Temp+" C");
        sunrise.setText(Sunrise+"");
        sunset.setText(Sunset+"");
        pressure.setText(Pressure+" hPa");
        humidity.setText(Humidity+" %");














    }
}