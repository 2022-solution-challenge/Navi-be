package com.google.solution.config;

import com.google.maps.GeoApiContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GoogleApiConfig {

    @Value("${spring.google.api_key}")
    private String apiKey;

    @Bean
    public GeoApiContext geoApiContext(){
        return new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

}
