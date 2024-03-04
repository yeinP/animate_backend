package org.yeinp.animate.animate_backend.user.controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yeinp.animate.animate_backend.entity.User;
import org.yeinp.animate.animate_backend.user.repository.UserRepository;
import org.yeinp.animate.animate_backend.user.service.JwtService;
import org.yeinp.animate.animate_backend.user.service.UserService;


import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/animate/user/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse response, HttpSession session){
        User user = userRepository.findByUserIdAndUserPassword(params.get("userId"), params.get("userPassword"));
        if(user != null){

            Long userNo =  user.getUserNo();
            String token = jwtService.getToken("userNo", userNo);

            Cookie cookie = new Cookie("token", token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            session.setAttribute("userNo", userNo);

            return new ResponseEntity<>(userNo, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/animate/user/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false)String token){
        Claims claims =jwtService.getClaims(token);
        if(claims != null){
            int userNo = Integer.parseInt(claims.get("userNo").toString());
            return new ResponseEntity<> (userNo,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
