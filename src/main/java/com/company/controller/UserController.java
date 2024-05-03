package com.company.controller;

import com.company.model.dto.ResponseDTO;
import com.company.model.form.UserForm;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public Mono<?> createUser(
            @RequestBody UserForm userForm
    ) {

        return userService.addUser(userForm);
    }


    @GetMapping("/list")
    public Mono<?> listUser() {

        return userService.getAllUsers();
    }



}
