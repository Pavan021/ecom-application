package com.app.ecom_application;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> fetchUsers() {
        return users;
    }

    public User addUser(User user){
        users.add(user);
        return user;
    }
}
