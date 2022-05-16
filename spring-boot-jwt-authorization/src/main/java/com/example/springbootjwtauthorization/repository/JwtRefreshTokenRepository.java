package com.example.springbootjwtauthorization.repository;

import com.example.springbootjwtauthorization.model.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {


}
