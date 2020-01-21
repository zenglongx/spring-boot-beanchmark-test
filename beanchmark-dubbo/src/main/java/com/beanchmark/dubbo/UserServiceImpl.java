package com.beanchmark.dubbo;

import com.beanchmark.dubbo.api.UserService;
import com.beanchmark.dubbo.api.dto.UserDto;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    @Override
    public UserDto findUserByUsername(String username) {
        return new UserDto("user","$2a$10$H1EUcEBNb6HL0pC9rieF9OLG80HlvKPN1TV2lK9lWd.JR561/zwrW");
    }
}
