package org.yeinp.animate.animate_backend.miss.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
public class ReplyDto {
    private Long replyNo;

    private Long replyWriter;

    private Long mcNo;

    private String reply;

    private Timestamp replyDate;

    private Long userNo;

    private String userNickname;
}
