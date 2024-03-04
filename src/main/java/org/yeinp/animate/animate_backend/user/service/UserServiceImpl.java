package org.yeinp.animate.animate_backend.user.service;

//import org.springframework.security.crypto.bcryptnpm.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yeinp.animate.animate_backend.entity.User;
import org.yeinp.animate.animate_backend.exception.DuplicateNicknameException;
import org.yeinp.animate.animate_backend.exception.DuplicateUserIdException;
import org.yeinp.animate.animate_backend.user.dto.UserDto;
import org.yeinp.animate.animate_backend.user.repository.UserRepository;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    final UserRepository userRepository;

    @Transactional
    @Override
    public void userRegister(UserDto userDto) throws Exception {
        validateDuplicate(userDto.getUserId(), userDto.getUserNickname());

        String userId = userDto.getUserId();
        String userPassword = userDto.getUserPassword();
        String UserName = userDto.getUserName();
        int userStatus = userDto.getUserStatus();
        String userNickname = userDto.getUserNickname();
        String userEmail =  userDto.getUserEmail();
        String userPhone = userDto.getUserPhone();

        User data = new User();

        data.setUserName(UserName);
        data.setUserId(userId);
        data.setUserPassword(userPassword);
        data.setUserStatus(1);
        data.setUserNickname(userNickname);
        data.setUserEmail(userEmail);
        data.setUserPhone(userPhone);

        userRepository.save(data);
    }

    @Override
    public void validateDuplicate(String userId, String userNickname) {
        if(userRepository.existsByUserId(userId)){
            throw new DuplicateUserIdException();
        }
        if(userRepository.existsByUserNickname(userNickname)){
            throw new DuplicateNicknameException();
        }
    }

//    @Override
//    public boolean checkUserIdDuplicate(String userId) {
//        return userRepository.existsByUserId(userId);
//    }
//
//    @Override
//    public boolean checkUserNicknameDuplicate(String userNickName) {
//        return userRepository.existsByUserNickname(userNickName);
//    }


}
