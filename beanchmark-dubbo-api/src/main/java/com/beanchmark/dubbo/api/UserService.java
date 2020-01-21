package com.beanchmark.dubbo.api;

import com.beanchmark.dubbo.api.dto.UserDto;

public interface UserService {
    UserDto findUserByUsername(String username);
}
