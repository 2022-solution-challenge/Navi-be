package com.google.solution.user;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.http.HttpHeaders.AUTHORIZATION;

@Component
public class OAuthProvider {

    @Value("${spring.google.oauth.client_id}")
    private String clientId ;
    @Value("${spring.google.oauth.client_secret}")
    private String clientSecret ;
    @Value("${spring.google.oauth.redirect_uri:http://localhost:8080/login/oauth2/google}")
    private String REDIRECT_URI;

    private static final String AUTHORIZATION_CODE = "authorization_code";

    public UserInfo getUserInfoByApi(String code) {
        String access_token = getAccessTokenByApi(code);
        JsonNode body = Unirest.get("https://www.googleapis.com/oauth2/v1/userinfo")
                .header(AUTHORIZATION, "Bearer " + access_token.trim()).asJson().getBody();

        return getUserInfo(body);
    }

    private UserInfo getUserInfo(JsonNode body) {
        String email = body.getObject().getString("email");
        String name = body.getObject().getString("name");
        return new UserInfo(name, email);
    }

    private String getAccessTokenByApi(String code) {
        HttpResponse<JsonNode> response = Unirest.post("https://oauth2.googleapis.com/token")
                .field("client_id", clientId)
                .field("client_secret", clientSecret)
                .field("code", code)
                .field("grant_type", AUTHORIZATION_CODE)
                .field("redirect_uri", REDIRECT_URI)
                .asJson();
        String access_token = response.getBody().getObject().getString("access_token");
        return access_token;
    }

    @Getter
    public class UserInfo {
        private String username;
        private String userEmail;

        public UserInfo(String username, String userEmail) {
            this.username = username;
            this.userEmail = userEmail;
        }
    }
}
