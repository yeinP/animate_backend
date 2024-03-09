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
@Table(name = "ar_re_reply")
public class ArReReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arReReplyNo;

    private Long arReReplyWriter;

    private Long arReplyNo;

    private Timestamp arReReplyDate;

    private String arReReply;

    private Long arNo;
}
