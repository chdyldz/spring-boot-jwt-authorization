package com.example.springbootjwtauthorization.service;

import com.example.springbootjwtauthorization.model.JwtRefreshToken;
import com.example.springbootjwtauthorization.model.User;
public interface JwtRefreshTokenService {

    JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
