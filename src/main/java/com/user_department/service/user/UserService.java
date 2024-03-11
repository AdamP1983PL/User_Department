package com.user_department.service.user;

import com.user_department.service.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> findAllUsers();

    UserDto findUserByUserName(String username);

    UserDto createUser(UserDto userDto);

    UserDto updateUser (UserDto userDto, String username);

    void deleteUser (String username);

}
