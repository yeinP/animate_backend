package org.yeinp.animate.animate_backend.user.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto{

    private Long userNo;

    private String userId;

    private String userPassword;

    private String userName;
    private int userStatus;
    private String userNickname;

    private String userEmail;
    private String userPhone;


}

