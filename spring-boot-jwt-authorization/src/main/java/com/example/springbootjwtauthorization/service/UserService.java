package com.example.springbootjwtauthorization.service;

import com.example.springbootjwtauthorization.model.Role;
import com.example.springbootjwtauthorization.model.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> findByUsername(String name);

    void changeRole(Role newRole, String userName);
}
