package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import java.util.ArrayList;

public class AdapterWthr extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener{

    Context context;
    ArrayList<String> days;
    ArrayList<Integer> images;
    DataWeather myweatherData;
    public AdapterWthr(Context context, ArrayList<String> days, DataWeather weatherData) {
        this.context = context;
        this.days = days;
        this.images = images;
        this.myweatherData = weatherData;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_weather_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.day.setText(days.get(position));
        final String imageURL =  "https://openweathermap.org/img/wn/"+ myweatherData.getDaily().get(position).getWeather().get(0).getIcon() +"@2x.png";
        Glide.with(context).load(imageURL).into(holder.image);


        holder.description.setText(myweatherData.getDaily().get(position).getWeather().get(0).getDescription());
        holder.minTemp.setText("min "+myweatherData.getDaily().get(position).getTemperature().getMin()+"");
        holder.maxTemp.setText("max "+myweatherData.getDaily().get(position).getTemperature().getMax()+"");

        //when clicked on any item
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,WeatherActivity.class);
                intent.putExtra("Position",position);
                intent.putExtra("Temperature",myweatherData.getDaily().get(position).getTemperature().getDay());
                intent.putExtra("Description",myweatherData.getDaily().get(position).getWeather().get(0).getDescription());
                intent.putExtra("Feels Like",myweatherData.getDaily().get(position).getFeelsLike().getDay());
                intent.putExtra("ImageURL",imageURL);

                intent.putExtra("Pressure",myweatherData.getDaily().get(position).getPressure());
                intent.putExtra("Wind",myweatherData.getDaily().get(position).getWindSpeed());
                intent.putExtra("Sunrise",myweatherData.getDaily().get(position).getSunrise());
                intent.putExtra("Sunset",myweatherData.getDaily().get(position).getSunset());

                intent.putExtra("Humidity",myweatherData.getDaily().get(position).getHumidity());




                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    @Override
    public void onClick(View v) {

    }

   /* @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,WeatherActivity.class);
        intent.putExtra("zain",5);
        context.startActivity(intent);
    }*/

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView day,description,minTemp,maxTemp;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            day= itemView.findViewById(R.id.dayView);
            description = itemView.findViewById(R.id.desView);
            maxTemp = itemView.findViewById(R.id.maxView);
            minTemp = itemView.findViewById(R.id.minVew);






        }
    }
}
