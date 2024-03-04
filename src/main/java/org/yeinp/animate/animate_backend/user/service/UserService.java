package org.yeinp.animate.animate_backend.user.service;


import org.yeinp.animate.animate_backend.user.dto.UserDto;

public interface UserService {

    public void userRegister(UserDto userDto) throws Exception;

    void validateDuplicate(String userId, String userNickname);

//    default User userDtoToEntity(UserDto userDto) {
//        User entity = User.builder().userNo(userDto.getUserNo()).userId(userDto.getUserId()).userPassword(userDto.getUserPassword()).userName(userDto.getUserName()).userStatus(userDto.getUserStatus()).userNickname(userDto.getUserNickname()).userEmail(userDto.getUserEmail()).userPhone(userDto.getUserPhone()).build();
//        return entity;
//    }
//
//    default UserDto entityToUserDto(User user) {
//        UserDto userDto = UserDto.builder().userNo(user.getUserNo()).userId(user.getUserId()).userPassword(user.getUserPassword()).userName(user.getUserName()).userStatus(user.getUserStatus()).userNickname(user.getUserNickname()).userEmail(user.getUserEmail()).userPhone(user.getUserPhone()).build();
//        return userDto;
//    }
}
