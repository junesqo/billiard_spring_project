package kg.junesqo.billiard.dto.authenticationDto;

import kg.junesqo.billiard.enums.Role;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

}