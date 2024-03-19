package org.yeinp.animate.animate_backend.adoption.service;

import org.springframework.http.ResponseEntity;
import org.yeinp.animate.animate_backend.adoption.dto.*;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;


import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface AdoptionService {

    int writeArArticle(AdoptionReviewDto adoptionReviewDto, List<String> imageUrls);

    List<ImgUrlDto> arImgUrl();
    Optional<AdoptionArticleDto> getAdoptionReviewWithImages(Long arNo);

    void removeReview(Long arNo);


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

    default List<AdoptionImg> dtoListToEntityList(List<String> imageUrls, AdoptionReview adoptionReview) {
        return imageUrls.stream()
                .map(imageUrl -> AdoptionImg.builder().adoptionReview(adoptionReview).arImgUrl(imageUrl).build())
                .collect(Collectors.toList());
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

    default AdoptionArticleDto entityToArticleDto(AdoptionReview adoptionReview, String userNickname) {
        return AdoptionArticleDto.builder()
                .arNo(adoptionReview.getArNo())
                .arRegdate(adoptionReview.getArRegdate())
                .userNo(adoptionReview.getUserNo())
                .arTitle(adoptionReview.getArTitle())
                .arContent(adoptionReview.getArContent())
                .userNickname(userNickname)
                .adoptionReviewImgList(entityListToDtoList(adoptionReview.getAdoptionReviewImgList()))
                .build();
    }

    default List<AdoptionImgDto> entityListToDtoList(List<AdoptionImg> adoptionImgList) {
        if (adoptionImgList == null) {
            return Collections.emptyList();
        }

        return adoptionImgList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    default AdoptionImgDto entityToDto(AdoptionImg adoptionImg) {
        return AdoptionImgDto.builder()
                .arImgNo(adoptionImg.getArImgNo())
                .arImgUrl(adoptionImg.getArImgUrl())
                .build();
    }



}
