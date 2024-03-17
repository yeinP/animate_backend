package org.yeinp.animate.animate_backend.adoption.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.adoption.dto.*;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionImgRepository;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionRepository;
import org.yeinp.animate.animate_backend.adoption.service.AdoptionService;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.home.dto.HomeARDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:3000")
@Slf4j
public class AdoptionReviewController {

    @Autowired
    AdoptionRepository adoptionRepository;

    @Autowired
    AdoptionService adoptionService;

    @Autowired
    AdoptionImgRepository adoptionImgRepository;

    @GetMapping("/adoption/review/list")
    @ResponseBody
    public List<AdoptionReviewReqDto> getAdoptionReviewDtoList(){
        return adoptionRepository.getArList();
    }



    @GetMapping("/adoption/review/imgList")
    @ResponseBody
    public List<ImgUrlDto> getAdoptionImgList(){
        return adoptionService.arImgUrl();
    }

    @GetMapping("/adoption/review/{arNo}")
    public ResponseEntity<AdoptionArticleDto> getAdoptionReview(@PathVariable Long arNo) {
        Optional<AdoptionArticleDto> adoptionArticleDtoOptional = adoptionService.getAdoptionReviewWithImages(arNo);

        return adoptionArticleDtoOptional
                .map(adoptionArticleDto -> ResponseEntity.ok().body(adoptionArticleDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
