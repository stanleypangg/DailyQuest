package com.dailyquest.dailyquest.user.dto;

import com.dailyquest.dailyquest.user.UserModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDtoMapper implements Function<UserModel, UserDto> {

    @Override
    public UserDto apply(UserModel userModel) {
        return new UserDto(
                userModel.getId(),
                userModel.getUsername(),
                userModel.getEmail()
        );
    }
}
