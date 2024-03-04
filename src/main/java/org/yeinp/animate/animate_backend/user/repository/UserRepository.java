
package org.yeinp.animate.animate_backend.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserIdAndUserPassword(String userId, String userPassword);

    boolean existsByUserId(String userId);

    boolean existsByUserNickname(String userNickName);

}
