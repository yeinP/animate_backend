package org.yeinp.animate.animate_backend.like.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikesDto {
    private Long likeNo;

    private Long userNo;

    private Long arNo;

    private char likeStatus;

}
