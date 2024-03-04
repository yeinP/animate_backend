package org.yeinp.animate.animate_backend.miss.dto;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class McReReplyReqDto {
    private Long reReplyNo;

    private Long reReplyWriter;

    private Long replyNo;

    private Timestamp reReplyDate;

    private String reReply;

    private Long userNo;

    private String userNickname;

    private Long mcNo;
}
