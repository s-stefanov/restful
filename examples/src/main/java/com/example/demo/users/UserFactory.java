package com.example.demo.users;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class UserFactory {
    private final Faker faker;

    public UserFactory() {this.faker = new Faker();}

    public User getUser() {
        final User user = new User();
        user.setId(faker.number().randomNumber());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        return user;
    }
}
