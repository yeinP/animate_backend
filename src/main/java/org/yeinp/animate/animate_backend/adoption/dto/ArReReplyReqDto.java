package org.yeinp.animate.animate_backend.adoption.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArReReplyReqDto {
    private Long arReReplyNo;

    private Long arReReplyWriter;

    private Long arReplyNo;

    private Timestamp arReReplyDate;

    private String arReReply;

    private Long userNo;

    private String userNickname;

    private Long arNo;
}
