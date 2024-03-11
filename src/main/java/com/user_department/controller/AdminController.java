package com.user_department.controller;

import com.user_department.service.user.UserServiceImpl;
import com.user_department.service.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userServiceImpl;

    @GetMapping("/users")
    public String listAllUsers(Model model) {
        List<UserDto> users = userServiceImpl.findAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }

    @GetMapping("/create-user")
    public String createUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "create-new-user";
    }

    @PostMapping("/save-new-user")
    public String saveNewUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "create-new-user";
        }

        userServiceImpl.createUser(userDto);
        log.info("====>>>> saveNewUser() execution");
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{userId}")
    public String editUser(@PathVariable("userId") Long userId, Model model) {
        UserDto userDto = userServiceImpl.findUserById(userId);
        model.addAttribute("userDto", userDto);
        return "edit-user";
    }

    @PostMapping("/update/{userId}")
    public String updateUser(@PathVariable("userId") Long userId,
                             @Valid @ModelAttribute("userDto") UserDto userDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "edit-user";
        }
        userDto.setId(userId);
        userServiceImpl.mvcUpdateUser(userDto);
        return "redirect:/admin/users";
    }

    @GetMapping("/details/{userId}")
    public String showUserDetails(@PathVariable("userId") Long id, Model model) {
        UserDto userDto = userServiceImpl.findUserById(id);
        model.addAttribute("userDto", userDto);
        return "user-details";
    }

    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userServiceImpl.deleteUser(userId);
        return "redirect:/admin/users";
    }

}
