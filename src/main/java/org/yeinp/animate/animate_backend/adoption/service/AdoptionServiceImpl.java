package org.yeinp.animate.animate_backend.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.adoption.dto.*;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionImgRepository;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionRepository;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;
import org.yeinp.animate.animate_backend.entity.User;
import org.yeinp.animate.animate_backend.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdoptionServiceImpl implements AdoptionService{

    @Autowired
    AwsS3ArService awsS3ArService;
    @Autowired
    AdoptionRepository adoptionRepository;

    @Autowired
    AdoptionImgRepository adoptionImgRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public int writeArArticle(AdoptionReviewDto AdoptionReviewDto, List<String> imageUrls) {
        AdoptionReview entity = arDtoToEntity(AdoptionReviewDto);
        List<AdoptionImg> adoptionImgs = new ArrayList<>();

        for(String imageUrl : imageUrls){
            adoptionImgs.add(AdoptionImg.builder().adoptionReview(entity).arImgUrl(imageUrl).build());

        }
        entity.setAdoptionReviewImgList(adoptionImgs);
        adoptionRepository.save(entity);
        return 0;
    }

    @Override
    public List<ImgUrlDto> arImgUrl() {
        List<AdoptionImg> resultList = adoptionImgRepository.findAll();
        return resultList.stream()
                .map(this::entityToImgUrlDto).collect(Collectors.toList());
    }

    @Override
    public Optional<AdoptionArticleDto> getAdoptionReviewWithImages(Long arNo) {
        Optional<AdoptionReview> adoptionReviewOptional = adoptionRepository.findById(arNo);

        return adoptionReviewOptional.map(adoptionReview -> {
            User user = userRepository.findById(adoptionReview.getUserNo()).orElse(null);

            if (user != null) {
                return entityToArticleDto(adoptionReview, user.getUserNickname());
            } else {
                return entityToArticleDto(adoptionReview, null);
            }
        });
    }


}
