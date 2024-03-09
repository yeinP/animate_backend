package org.yeinp.animate.animate_backend.adoption.dto;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArReReplyDto {
    private Long arReReplyNo;

    private Long arReReplyWriter;

    private Long arReplyNo;

    private Timestamp arReReplyDate;

    private String arReReply;

    private Long arNo;
}
