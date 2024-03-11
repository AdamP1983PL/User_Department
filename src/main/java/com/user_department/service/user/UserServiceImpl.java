package com.user_department.service.user;

import com.user_department.exceptions.ResourceNotFoundException;
import com.user_department.exceptions.UsernameAlreadyExistsException;
import com.user_department.model.user.domain.User;
import com.user_department.model.user.repository.UserRepository;
import com.user_department.service.user.dto.UserDto;
import com.user_department.service.user.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public UserDto findUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                        .orElseThrow(() -> new ResourceNotFoundException("User", "username",  username));
        log.info("====>>>> findUserByUsername(" + username + ") execution.");
        return userMapper.mapToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUsername(userDto.getUsername());
        if(user.isPresent()) {
            throw new UsernameAlreadyExistsException("Username", userDto.getUsername());
        }

        User savedUser = userRepository.save(userMapper.mapToUser(userDto));
        log.info("====>>>> createUser() execution.");
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, String username) {
        User user = userRepository.findByUsername(username)
                .map(u -> {
                    u.setFirstName(userDto.getFirstName());
                    u.setLastName(userDto.getLastName());
                    u.setPassword(userDto.getPassword());
                    u.setAuthorities(userDto.getAuthorities());
                    return userRepository.save(u);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        log.info("====>>>> updateUser() execution.");
        return userMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username",  username));
        log.info("====>>>> deleteUser(" + username + ") execution.");
        userRepository.delete(user);
    }
}
