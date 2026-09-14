package com.app.ecom_application.service;

import com.app.ecom_application.models.User;
import com.app.ecom_application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@NoArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    //private List<User> userList = new ArrayList<>();
    //private Long nextId = 1L;

    public List<User> fetchUsers() {

        return userRepository.findAll();
    }

    public void addUser(User user){
        //user.setId(nextId++);
        userRepository.save(user);
    }

    public Optional<User> fetchUser(Long id) {

//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();

        return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    return true;
                }).orElse(false);
    }
}
