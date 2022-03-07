package com.google.solution.accident;

import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Map;


@Component
public class AccidentDataApiProvider {

    private static final String httpUrl = "http://apis.data.go.kr/B552061/frequentzoneChild/getRestFrequentzoneChild";


    @Value("${spring.public-data.key}")
    private String serviceKey;


    public void apiTest(){
        String uriString = urlStringBuilder(httpUrl);

        HttpResponse<String> response = Unirest.get(uriString)
                .asString();

        System.out.println(response.getBody());

    }

    private String urlStringBuilder(String url) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        ObjectMapper objectMapper = new ObjectMapper();
        MultiValueMap params = new LinkedMultiValueMap<>();

        AccidentApiQueryParameter queryParameters = new AccidentApiQueryParameter(serviceKey, 2015, "11", "320");
        Map<?, ?> values = objectMapper.convertValue(queryParameters, Map.class);
        params.setAll(values);

        String uriString = builder.queryParams(params).build(false).toUriString();
        return uriString;
    }


}
