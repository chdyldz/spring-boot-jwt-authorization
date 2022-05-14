package com.example.springbootjwtauthorization.service;

import com.example.springbootjwtauthorization.model.Role;
import com.example.springbootjwtauthorization.model.User;
import com.example.springbootjwtauthorization.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String name){
        return userRepository.findByUsername(name);
    }

    @Override
    @Transactional
    public void changeRole(Role newRole, String userName){
        userRepository.updateUserRole(userName,newRole);
    }



}
