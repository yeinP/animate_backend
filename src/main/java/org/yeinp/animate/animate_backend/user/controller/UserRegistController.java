package org.yeinp.animate.animate_backend.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.exception.DuplicateNicknameException;
import org.yeinp.animate.animate_backend.exception.DuplicateUserIdException;
import org.yeinp.animate.animate_backend.user.dto.UserDto;
import org.yeinp.animate.animate_backend.user.service.UserService;


@Controller
public class UserRegistController {

    @Autowired
    private UserService userService;

    @PostMapping("/animate/user/register")
    public ResponseEntity<String> userRegist(@RequestBody @Valid UserDto userDto)throws Exception{
        try {
            userService.userRegister(userDto);
            return ResponseEntity.ok("회원가입이 완료되었습니다. 로그인 화면으로 돌아갑니다");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    @PostMapping("/animate/user/duplicateUserId")
    @ResponseBody
    public ResponseEntity<String> validateDuplicateUserId(@RequestBody String userId) {
        try {
            userService.validateDuplicateUserId(userId);
            return ResponseEntity.ok("false"); // 중복이 발견되지 않았을 때는 false 반환
        } catch (DuplicateUserIdException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("true"); // 중복이 발견되었을 때는 true 반환
        }
    }

    @PostMapping("/animate/user/duplicateUserNickname")
    @ResponseBody
    public ResponseEntity<String> validateDuplicateUserNickname(@RequestBody String userNickname) {
        try {
            userService.validateDuplicateUserNickname(userNickname);
            return ResponseEntity.ok("false"); // 중복이 발견되지 않았을 때는 false 반환
        } catch (DuplicateNicknameException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("true"); // 중복이 발견되었을 때는 true 반환
        }
    }
    


}
