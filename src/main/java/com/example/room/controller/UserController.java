package com.example.room.controller;

import com.example.room.model.Role;
import com.example.room.model.User;
import com.example.room.service.roles.IRoleService;
import com.example.room.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final String DEFAULT_ROLE = "USER";

    @GetMapping("/registration")
    public ModelAndView formRegistration(){
        return new ModelAndView("users/registration", "user", new User());
    }

    @PostMapping("/register")
    public ModelAndView registration(@ModelAttribute User user){
        Role role = roleService.findByName(DEFAULT_ROLE).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("users/registration");
        modelAndView.addObject("message", "Đăng ký thành công");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {
        return new ModelAndView("users/login");
    }

    @PostMapping("/login")
    public ModelAndView login(User user){
        ModelAndView modelAndView;
        if (userService.checkLogin(user)) {
            modelAndView = new ModelAndView("rooms/list");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView = new ModelAndView("users/login");
        modelAndView.addObject("MESSAGE", "username or password incorrect");
        return modelAndView;
    }
}
