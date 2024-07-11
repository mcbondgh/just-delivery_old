package com.app.api;

import com.app.config.DbProperties;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixElementStatus;

import static com.app.config.DbProperties.loadProps;

public class MapApiCall {
    public static void main(String[] args) {
        String API_KEY = loadProps().getProperty("map.api.key");
        GeoApiContext apiContext = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();

        try {
            String[] startPoint = {"Koforidua, Eastern Region, Ghana"};
            String[] destination = {"Madina, Accra, Ghana"};

            DistanceMatrix result = DistanceMatrixApi.getDistanceMatrix(apiContext, startPoint, destination).await();

            if (result.rows[0].elements[0].status == DistanceMatrixElementStatus.OK) {
                System.out.println("Distance: " + result.rows[0].elements[0].distance.humanReadable);
                System.out.println("Duration: " + result.rows[0].elements[0].duration.humanReadable);
            } else {
                System.out.println("Error: " + result.rows[0].elements[0].status);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        apiContext.shutdown();
    }
}
