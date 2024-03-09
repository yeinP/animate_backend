package org.yeinp.animate.animate_backend.adoption.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArReplyDto {
    private Long arReplyNo;

    private Long replyWriter;

    private Long arNo;

    private String reply;

    private Timestamp replyDate;
}
