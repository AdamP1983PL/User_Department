package com.user_department.service.user.dto;

import com.user_department.model.authority.Authority;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    @NotEmpty(message = "First name should not be empty.")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty.")
    private String lastName;
    @NotEmpty(message = "Username should not be empty.")
    private String username;
    @NotEmpty(message = "Password should not be empty.")
    private String password;
    private Set<Authority> authorities;

}
