package com.beanchmark.dubbo;

import com.beanchmark.dubbo.api.UserService;
import com.beanchmark.dubbo.api.dto.UserDto;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public UserDto findUserByUsername(String username) {
        return new UserDto(username,"password");
//        return new UserDto(username,"$2a$04$CLu8kvKxz.A4F3CVsJa9Meiu3sMey6z89pl9fX5rSkeIkbii4I6LC");
//        return new UserDto(username,"{dmWnXm8c66ewL3NjbwSc5IqT9R8pPJ7oAV1hjxKSybU=}72b0de71def11d4f722ee9ec2668ffa4");
    }
}
