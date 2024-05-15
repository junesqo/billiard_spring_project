package kg.junesqo.billiard.dto.authenticationDto;

import kg.junesqo.billiard.enums.Role;

public class AuthenticationResponse {
    private Long id;
    private String token;
    private String email;
    private Role role;
}
