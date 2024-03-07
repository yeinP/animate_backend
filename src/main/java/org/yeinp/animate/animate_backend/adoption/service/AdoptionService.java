package org.yeinp.animate.animate_backend.adoption.service;

import org.yeinp.animate.animate_backend.adoption.dto.AdoptionImgDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.adoption.dto.ImgUrlDto;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;
import org.yeinp.animate.animate_backend.entity.MissCareImg;
import org.yeinp.animate.animate_backend.miss.dto.MissCareImgDto;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface AdoptionService {

    int writeArArticle(AdoptionReviewDto adoptionReviewDto, List<String> imageUrls);

    List<ImgUrlDto> arImgUrl();

    default ImgUrlDto entityToImgUrlDto(AdoptionImg adoptionImg){
        return ImgUrlDto.builder()
                .arImgNo(adoptionImg.getArImgNo())
                .arNo(adoptionImg.getAdoptionReview().getArNo())
                .arImgUrl(adoptionImg.getArImgUrl())
                .build();
    }

    default AdoptionReview arDtoToEntity(AdoptionReviewDto adoptionReviewDto){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        return AdoptionReview.builder().
                arNo(adoptionReviewDto.getArNo()).
               arRegdate(today).
                userNo(adoptionReviewDto.getUserNo()).
                arTitle(adoptionReviewDto.getArTitle()).
                arContent(adoptionReviewDto.getArContent()).
                build();

    }

    default AdoptionImgDto entityToAdoptionImgDto(AdoptionImg adoptionImg){
        return AdoptionImgDto.builder().
                arImgNo(adoptionImg.getArImgNo())
                .arImgUrl(adoptionImg.getArImgUrl())
                .arNo(adoptionImg.getArImgNo()).build();

    }

    default AdoptionReviewDto entityToAdoptionReviewDto(AdoptionReview adoptionReview){
        return AdoptionReviewDto.builder()
                .arNo(adoptionReview.getArNo())
                .arRegdate(adoptionReview.getArRegdate())
                .userNo(adoptionReview.getUserNo())
                .arTitle(adoptionReview.getArTitle())
                .arContent(adoptionReview.getArContent())
                .build();
    }


}
