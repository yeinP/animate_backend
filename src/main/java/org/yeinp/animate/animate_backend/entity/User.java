package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column(length = 20, nullable = false, unique = true)
    private String userId;
    @Column(length = 30, nullable = false)
    private String userPassword;
    @Column(length = 10)
    private String userName;
    private int userStatus;
    private String userNickname;
    private String userEmail;
    private String userPhone;
}
