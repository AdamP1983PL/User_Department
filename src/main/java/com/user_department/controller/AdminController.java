package com.user_department.controller;

import com.user_department.service.user.UserService;
import com.user_department.service.user.UserServiceImpl;
import com.user_department.service.user.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AdminController {

    private UserServiceImpl userServiceImpl;

    @GetMapping("/admin/users")
    public String listAllUsers(Model model) {
        List<UserDto> users = userServiceImpl.findAllUsers();
        model.addAttribute("users", users);
        return "users-list";
    }

}
