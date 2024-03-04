package org.yeinp.animate.animate_backend.miss.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MissCareDto {
    private Long mcNo;
    private String mcAddr;
    private Timestamp mcRegdate;
    private int mcStatus;
    private Long userNo;
    private String mcLoc;
    private int mcAnimalNo;
    private String mcBreed;
    private String mcGender;
    private int mcAge;
    private int mcWeight;
    private String mcColor;
    private String mcChar;
    private String mcEtc;
    private String mcImgUrl;
}
