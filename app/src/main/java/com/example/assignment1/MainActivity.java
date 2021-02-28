package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    RequestQueue requestQueue;
    DataWeather weatherData;



    ArrayList<String> dayNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Days();







        requestQueue = Volley.newRequestQueue(this);
        fetchJsonResponse();
    }



    public  void Days(){
        dayNames = new ArrayList<String>();
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        dayNames.add("Sunday");
    }



    public void SetRecyclerview(DataWeather myweatherData){

        DataWeather weatherData = myweatherData;

        RecyclerView recyclerView = findViewById(R.id.rcylvw);

        //Decoration - Divider between items
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        AdapterWthr weatherAdapter = new AdapterWthr(this, dayNames, weatherData);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(weatherAdapter);



    }







    private void fetchJsonResponse() {
        // Pass second argument as "null" for GET requests
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "https://api.openweathermap.org/data/2.5/onecall?lat=31.520370&lon=74.358749&units=metric&exclude=current,minutely,hourly,alerts&appid=b42ba87bf8677332eeea240472d2b78b", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        weatherData= gson.fromJson(response.toString(),DataWeather.class);
                        Log.i("Tabraiz","Sunrise : "+weatherData.getDaily().get(0).getSunrise());
                        SetRecyclerview(weatherData);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        requestQueue.add(req);
    }










}