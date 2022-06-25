package com.example.springbootjwtauthorization.service;

import com.example.springbootjwtauthorization.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
