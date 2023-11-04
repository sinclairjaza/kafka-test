package com.kafkatest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private int age;
}
