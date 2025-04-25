package org.senuka.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.senuka.dto.AuthResponse;
import org.senuka.dto.LoginUser;
import org.senuka.dto.RegisterUser;
import org.senuka.dto.User;
import org.senuka.entity.UserEntity;
import org.senuka.repository.UserRepository;
import org.senuka.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtServiceImpl jwtService;
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final ModelMapper mapper;


    @Override
    public AuthResponse login(LoginUser user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        UserEntity userEntity = userRepository.findByEmail(user.getEmail()).orElseThrow();

        System.out.println("User login : " + userEntity);

        String jwtToken = jwtService.generateToken(userEntity);
        return AuthResponse.builder()
                .token(jwtToken)
                .user(mapper.map(userEntity, User.class))
                .build();

    }

    @Override
    public AuthResponse register(RegisterUser user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserEntity userEntity = userRepository.save(UserEntity.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .username(user.getUsername())
                .build());

        String token = jwtService.generateToken(userEntity);

        return AuthResponse.builder()
                .token(token)
                .user(mapper.map(userEntity, User.class))
                .build();
    }

    @Override
    public Boolean isTokenValid(String token) {
        return jwtService.isTokenExpired(token)
                && jwtService.isTokenValid(token, userRepository.findByEmail(jwtService.extractUsername(token))
                .orElseThrow(() -> new RuntimeException("User not found")));
    }
}
