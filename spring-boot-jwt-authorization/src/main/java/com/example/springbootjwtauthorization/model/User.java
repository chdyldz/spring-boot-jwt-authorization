package com.example.springbootjwtauthorization.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name ="password", nullable = false)
    private String password;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name ="name", nullable = false)
    private LocalDateTime createTime;

    @Column(name="role",nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;
}
