package org.yeinp.animate.animate_backend.adoption.dto;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArReqReplyDto {


    private Long arReplyNo;

    private Long replyWriter;

    private Long arNo;

    private String reply;

    private Timestamp replyDate;

    private Long userNo;

    private String userNickname;
}