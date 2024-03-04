package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="misscarereply")
public class MisscareReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyNo;

    private Long replyWriter;

    private Long mcNo;

    private String reply;

    private Timestamp replyDate;
}
