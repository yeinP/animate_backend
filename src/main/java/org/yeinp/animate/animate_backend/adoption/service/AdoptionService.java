package org.yeinp.animate.animate_backend.adoption.service;

import org.yeinp.animate.animate_backend.adoption.dto.AdoptionImgDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;


import java.util.List;

public interface AdoptionService {

    int writeArArticle(AdoptionReviewReqDto adoptionReviewReqDto, List<String> imageUrls);

    default AdoptionReview arDtoToEntity(AdoptionReviewReqDto adoptionReviewReqDto){
        return AdoptionReview.builder().
                arNo(adoptionReviewReqDto.getArNo()).
               arRegdate(adoptionReviewReqDto.getArRegdate()).
                userNo(adoptionReviewReqDto.getUserNo()).
                arTitle(adoptionReviewReqDto.getArTitle()).
                arContent(adoptionReviewReqDto.getArContent()).
                build();

    }


}
