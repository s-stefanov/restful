package com.example.demo.users;

import lombok.Data;
import net.datafaker.Faker;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
}
