package org.yeinp.animate.animate_backend.adoption.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AdoptionImgDto {
    private Long arImgNo;
    private Long arNo;
    private String arImgUrl;
}
