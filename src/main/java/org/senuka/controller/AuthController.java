package org.senuka.controller;

import lombok.RequiredArgsConstructor;
import org.senuka.dto.AuthResponse;
import org.senuka.dto.LoginUser;
import org.senuka.dto.RegisterUser;
import org.senuka.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginUser user) {

        try {
            AuthResponse authResponse = authService.login(user);
            return ResponseEntity.ok(authResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/test")
    public void test() {
        System.out.println("TEST CALLED" );
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterUser user) {
        System.out.println("Userx : " + user);


        try {
            AuthResponse authResponse = authService.register(user);
            return ResponseEntity.ok(authResponse);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam String token) {
        try {
            Boolean isValid = authService.isTokenValid(token);
            return ResponseEntity.ok(isValid);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
