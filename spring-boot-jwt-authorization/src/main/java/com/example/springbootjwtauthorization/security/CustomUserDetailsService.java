package com.example.springbootjwtauthorization.security;


import com.example.springbootjwtauthorization.model.User;
import com.example.springbootjwtauthorization.service.UserService;
import com.example.springbootjwtauthorization.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found With username " + username));

        Set<GrantedAuthority> authorities= Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        //USer details service
        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .authorities(authorities)
                .build();
    }
}
