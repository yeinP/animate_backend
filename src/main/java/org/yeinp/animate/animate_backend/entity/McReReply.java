package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mc_r_reply")

public class McReReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reReplyNo;

    private Long reReplyWriter;

    private Long replyNo;

    private Timestamp reReplyDate;

    private String reReply;

    private Long mcNo;
}
