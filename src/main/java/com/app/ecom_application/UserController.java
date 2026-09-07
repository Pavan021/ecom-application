package com.app.ecom_application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.fetchUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
}
