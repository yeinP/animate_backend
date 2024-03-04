package org.yeinp.animate.animate_backend.miss.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
public class MisscareReplyDto {

    private Long replyNo;

    private Long replyWriter;

    private Long mcNo;

    private String reply;

    private Timestamp replyDate;
}
