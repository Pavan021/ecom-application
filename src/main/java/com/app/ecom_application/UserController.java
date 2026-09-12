package com.app.ecom_application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(userService.fetchUsers(), HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id)
    {
        return userService.fetchUser(id)
                .map(ResponseEntity :: ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.ok("User Created Successfully !!");
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,  @RequestBody User user)
    {
        boolean isUpdated = userService.updateUser(id, user);
        if(isUpdated)
            return ResponseEntity.ok("User updated Successfully !!");
        return ResponseEntity.notFound().build();
    }
}
