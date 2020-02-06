package com.beanchmark;

import com.beanchmark.dubbo.api.UserService;
import com.beanchmark.dubbo.api.dto.UserDto;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Reference(version = "1.0.0", url = "dubbo://localhost:12345")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDto userDto = userService.findUserByUsername(username);
        return User
//                .withUsername(userDto.getUsername())
//                .password(userDto.getPassword())
                .withUsername(username)
                .password("password")
                .roles("USER")
                .build();
    }
}
