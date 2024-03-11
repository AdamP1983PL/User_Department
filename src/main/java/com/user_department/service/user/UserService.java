package com.user_department.service.user;

import com.user_department.service.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto findUserByUsername(String username);

    UserDto findUserById(Long id);

    UserDto createUser(UserDto userDto);

    UserDto updateUser (UserDto userDto, String username);

    void mvcUpdateUser(UserDto userDto);

    void deleteUser (Long id);

}
