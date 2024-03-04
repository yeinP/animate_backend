package org.yeinp.animate.animate_backend.miss.service;

import org.yeinp.animate.animate_backend.entity.MissCare;
import org.yeinp.animate.animate_backend.entity.MissCareAnimal;
import org.yeinp.animate.animate_backend.entity.MissCareImg;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareImgDto;
import org.yeinp.animate.animate_backend.miss.dto.ReplyDto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface MissService {
    int writeMissArticle(MissCareDto missCareDto, List<String> imageUrls);


    List<MissCareImgDto> mcImgUrlByMcNo(Long mcNo);

    default MissCareImgDto entityToMissCareImgDto(MissCareImg missCareImg){
        return MissCareImgDto.builder().
                mcImgNo(missCareImg.getMcImgNo())
                .mcImgUrl(missCareImg.getMcImgUrl())
                .mcNo(missCareImg.getMcImgNo()).build();

    }

    default MissCare missDtoToEntity(MissCareDto missCareDto){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        MissCare entity = MissCare.builder().mcNo(missCareDto.getMcNo()).
                mcRegdate(today).
                mcAddr(missCareDto.getMcAddr()).
                mcStatus(missCareDto.getMcStatus()).
                userNo(missCareDto.getUserNo()).
                mcLoc(missCareDto.getMcLoc()).
                build();
        return entity;
    }

    default MissCareAnimal missCareAnimalDtoToEntity(MissCareDto missCareDto, Long mcNo){
        return MissCareAnimal.builder().
                mcBreed(missCareDto.getMcBreed()).
                mcGender(missCareDto.getMcGender()).
                mcAge(missCareDto.getMcAge()).
                mcWeight(missCareDto.getMcWeight()).
                mcColor(missCareDto.getMcColor()).
                mcChar(missCareDto.getMcChar()).
                mcEtc(missCareDto.getMcEtc()).
                mcNo(mcNo).build();
    }



}
