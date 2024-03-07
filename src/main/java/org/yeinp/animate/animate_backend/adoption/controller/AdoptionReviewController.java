package org.yeinp.animate.animate_backend.adoption.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionImgDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.adoption.dto.ImgUrlDto;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionImgRepository;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionRepository;
import org.yeinp.animate.animate_backend.adoption.service.AdoptionService;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;

import java.util.List;

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

}
