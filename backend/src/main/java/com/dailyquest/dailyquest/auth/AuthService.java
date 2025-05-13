package com.dailyquest.dailyquest.auth;

import com.dailyquest.dailyquest.auth.dto.AuthRequestDto;
import com.dailyquest.dailyquest.auth.dto.AuthResponseDto;
import com.dailyquest.dailyquest.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponseDto login(AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.username(), authRequestDto.password()
                )
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequestDto.username());
        String token = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthResponseDto(token);
    }
}
