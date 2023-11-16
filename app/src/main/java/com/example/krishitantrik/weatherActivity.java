package com.example.krishitantrik;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class weatherActivity extends AppCompatActivity {

    double latitude;
    double longitude;
    double currentTemperature;
    TextView currentTemperatureTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        currentTemperatureTV = findViewById(R.id.currentTemperatureTV);




        getLocation();

            getUpdates();


    }

    private void getUpdates() {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + "c067effa089c585b73273fcc7cdc91d1";

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull okhttp3.Call call, IOException e) {
                // Handle error
            }

            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {
                assert response.body() != null;
                String responseData = response.body().string();

                try {
                    JSONObject jsonObject = new JSONObject(responseData);
                    JSONObject mainObject = jsonObject.getJSONObject("main");
                    currentTemperature = mainObject.getDouble("temp");

                    // Update UI elements on the main thread
                    runOnUiThread(() -> currentTemperatureTV.setText(String.valueOf((int) currentTemperature)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void getLocation() {

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String bestProvider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Please Provide Location Permission", Toast.LENGTH_SHORT).show();
        }
        assert bestProvider != null;
        Location location = locationManager.getLastKnownLocation(bestProvider);

        if (location != null) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        } else {
            // Handle location not available
            Toast.makeText(this, "Error in getting location", Toast.LENGTH_SHORT).show();
        }
    }
}