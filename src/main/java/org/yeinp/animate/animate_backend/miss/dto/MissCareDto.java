package org.yeinp.animate.animate_backend.miss.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
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
    private String mcLoc2;
    private Long mcAnimalNo;
    private String mcBreed;
    private String mcGender;
    private int mcAge;
    private int mcWeight;
    private String mcColor;
    private String mcChar;
    private String mcEtc;
    private String mcImgUrl;

    public MissCareDto(Long mcNo, String mcAddr, Timestamp mcRegdate, int mcStatus, Long userNo, String mcLoc, String mcLoc2, Long mcAnimalNo, String mcBreed, String mcGender, int mcAge, int mcWeight, String mcColor, String mcChar, String mcEtc, String mcImgUrl) {
        this.mcNo = mcNo;
        this.mcAddr = mcAddr;
        this.mcRegdate = mcRegdate;
        this.mcStatus = mcStatus;
        this.userNo = userNo;
        this.mcLoc = mcLoc;
        this.mcLoc2 = mcLoc2;
        this.mcAnimalNo = mcAnimalNo;
        this.mcBreed = mcBreed;
        this.mcGender = mcGender;
        this.mcAge = mcAge;
        this.mcWeight = mcWeight;
        this.mcColor = mcColor;
        this.mcChar = mcChar;
        this.mcEtc = mcEtc;
        this.mcImgUrl = mcImgUrl;
    }
}
