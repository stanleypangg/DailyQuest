package com.dailyquest.dailyquest.user;

import com.dailyquest.dailyquest.user.dto.CreateUserDto;
import com.dailyquest.dailyquest.user.dto.UserDto;
import com.dailyquest.dailyquest.user.exceptions.EmailAlreadyTakenException;
import com.dailyquest.dailyquest.user.exceptions.UsernameAlreadyTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

//    public List<UserDto> getAllUsers() {
//        return userRepo.findAll();
//        // convert to dtos
//    }

    public UserDto createUser(CreateUserDto createUserDto) {
        String hashedPassword = passwordEncoder.encode(createUserDto.password());

        // Check if username already taken
        if (userRepo.existsByUsername((createUserDto.username()))) {
            throw new UsernameAlreadyTakenException(createUserDto.username());
        }

        // Check if email already taken
        if (userRepo.existsByEmail((createUserDto.email()))) {
            throw new EmailAlreadyTakenException((createUserDto.email()));
        }

        UserModel userModel = new UserModel(
                createUserDto.username(),
                createUserDto.email(),
                hashedPassword
        );

        userRepo.save(userModel);

        return new UserDto(
                userModel.getUsername(),
                userModel.getEmail()
        );
    }
}
