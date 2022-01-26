package com.example.demo.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("")
@RequiredArgsConstructor
public class UsersController {
    private final UserFactory userFactory;

    @RequestMapping(path = "users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return List.of(userFactory.getUser(), userFactory.getUser(), userFactory.getUser());
    }

    @GetMapping("users/{id}")
    public User getUserById(@PathVariable Long id) {
        final User user = userFactory.getUser();
        user.setId(id);

        return user;
    }

    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user) {
        log.info(user.toString());
    }

    @PutMapping("user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {}

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable Long id) {}

    @GetMapping(value = "users", produces = "text/csv")
    public List<User> getUsersAsCsv() {
        return List.of(userFactory.getUser(), userFactory.getUser(), userFactory.getUser());
    }
}
