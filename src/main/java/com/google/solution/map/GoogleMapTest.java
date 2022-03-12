package com.google.solution.map;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GoogleMapTest {

    private GeoApiContext geoApiContext;

    public GoogleMapTest(GeoApiContext geoApiContext) {
        this.geoApiContext = geoApiContext;
    }

    public void test() throws IOException, InterruptedException, ApiException {
        System.out.println(geoApiContext);
        GeocodingResult[] results = GeocodingApi.geocode(geoApiContext,
                "광주과학기술원").await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].addressComponents));
    }
}
