package org.senuka.service;

import org.senuka.dto.AuthResponse;
import org.senuka.dto.LoginUser;
import org.senuka.dto.RegisterUser;
import org.senuka.dto.User;

public interface AuthService {
    AuthResponse login(LoginUser user);

    AuthResponse register(RegisterUser user);

    Boolean isTokenValid(String token);

}
