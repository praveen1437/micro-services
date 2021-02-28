package com.microservices.userservice.controller;

import com.microservices.userservice.VO.RestTemplateVO;
import com.microservices.userservice.entity.User;
import com.microservices.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("######### in userController save user");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public RestTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("######### in userController getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
