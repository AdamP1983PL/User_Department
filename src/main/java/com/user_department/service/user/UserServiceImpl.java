package com.user_department.service.user;

import com.user_department.model.user.domain.User;
import com.user_department.model.user.repository.UserRepository;
import com.user_department.service.user.dto.UserDto;
import com.user_department.service.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAllUsers() {
        log.info("====>>>> findAllUsers() execution.");
        return userRepository.findAll().stream()
                .map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserByUserName(String username) {

        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String username) {
        return null;
    }

    @Override
    public void deleteUser(String username) {

    }
}
