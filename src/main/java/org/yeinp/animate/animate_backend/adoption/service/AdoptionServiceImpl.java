package org.yeinp.animate.animate_backend.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdoptionServiceImpl implements AdoptionService{

    @Autowired
    AwsS3ArService awsS3ArService;



    @Override
    public int writeArArticle(AdoptionReviewReqDto adoptionReviewReqDto, List<String> imageUrls) {
        AdoptionReview entity = arDtoToEntity(adoptionReviewReqDto);
        List<AdoptionImg> adoptionImgs = new ArrayList<>();

        for(String imageUrl : imageUrls){
            adoptionImgs.add(AdoptionImg.builder().adoptionReview(entity).arImgUrl(imageUrl).build());

        }
        entity.setAdoptionReviewImgList(adoptionImgs);
        return 0;
    }
}
