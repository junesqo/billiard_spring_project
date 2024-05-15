package kg.junesqo.billiard.services;

import kg.junesqo.billiard.dto.authenticationDto.AuthenticationResponse;
import kg.junesqo.billiard.dto.authenticationDto.SignInRequest;
import kg.junesqo.billiard.dto.authenticationDto.SignUpRequest;
import kg.junesqo.billiard.dto.authenticationDto.UserResponse;

import java.util.List;

public interface AuthenticationService {

    AuthenticationResponse signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);

    List<UserResponse> getAllUsers();

}
