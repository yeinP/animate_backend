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
@Table(name="ar_reply")
public class ArReply {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long arReplyNo;

        private Long replyWriter;

        private Long arNo;

        private String reply;

        private Timestamp replyDate;

}
