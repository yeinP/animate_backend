package org.yeinp.animate.animate_backend.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.user.dto.UserDto;
import org.yeinp.animate.animate_backend.user.service.UserService;


@Controller
@RequiredArgsConstructor
public class UserRegistController {

    @Autowired
    private UserService userService;



    @PostMapping("/animate/user/register")
    public String userRegist(@RequestBody @Valid UserDto userDto)throws Exception{
        userService.userRegister(userDto);
        return "success";
    }


}
