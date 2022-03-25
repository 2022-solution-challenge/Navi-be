package com.google.solution.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String userEmail;

    private String userPhoneNumber;

    public User(String username, String password, String userEmail, String userPhoneNumber) {
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }
}
