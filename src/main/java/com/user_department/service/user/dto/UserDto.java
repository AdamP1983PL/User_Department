package com.user_department.service.user.dto;

import com.user_department.model.authority.Authority;
import com.user_department.model.enums.Role;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @Size(min = 3, max = 20)
    @NotEmpty(message = "First name should not be empty.")
    private String firstName;
    @Size(min = 3, max = 20)
    @NotEmpty(message = "Last name should not be empty.")
    private String lastName;
    @Size(min = 3, max = 30)
    @NotEmpty(message = "Username should not be empty.")
    private String username;
    @Size(min = 8, max = 20)
    @NotEmpty(message = "Password should not be empty.")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
