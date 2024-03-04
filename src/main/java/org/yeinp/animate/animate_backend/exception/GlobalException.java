package org.yeinp.animate.animate_backend.exception;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalException {
    @ExceptionHandler(DuplicateUserIdException.class)
    public JSONObject duplicateEmailException(){
        return ErrorResponse.JsonErrorResponse(400, "중복된 아이디 입니다.");
    }

    @ExceptionHandler(DuplicateNicknameException.class)
    public JSONObject duplicateNicknameException(){
        return ErrorResponse.JsonErrorResponse(400, "중복된 닉네임 입니다.");
    }
}
