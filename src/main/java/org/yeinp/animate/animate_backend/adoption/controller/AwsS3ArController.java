package org.yeinp.animate.animate_backend.adoption.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.adoption.dto.S3ArFileDto;
import org.yeinp.animate.animate_backend.adoption.service.AdoptionService;
import org.yeinp.animate.animate_backend.adoption.service.AdoptionServiceImpl;
import org.yeinp.animate.animate_backend.adoption.service.AwsS3ArService;
import org.yeinp.animate.animate_backend.miss.dto.S3MissFileDto;
import org.yeinp.animate.animate_backend.miss.service.AwsS3MissService;
import org.yeinp.animate.animate_backend.miss.service.MissService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animate" )
@RequiredArgsConstructor
public class AwsS3ArController {
    private final AwsS3ArService awsS3ArService;

    @Autowired
    AdoptionService adoptionService;

//    @PostMapping(value="/upload/adoption/review", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> uploadMissFile(@RequestParam(value = "files") List<MultipartFile> multipartFiles, @ModelAttribute AdoptionReviewDto adoptionReviewDto, HttpSession session){
//        Long userNo = (Long) session.getAttribute("userNo");
//        List<S3ArFileDto> s3ArFileDtoList = new ArrayList<>();
//        if(multipartFiles != null && !multipartFiles.isEmpty()){
//            s3ArFileDtoList = awsS3ArService.uploadImageAdotion(multipartFiles);
//            List<String> fileUrls = s3ArFileDtoList.stream().map(S3ArFileDto::getFileUrl).collect(Collectors.toList());
//            adoptionReviewDto.setUserNo(userNo);
//            int result = adoptionService.writeArArticle(adoptionReviewDto, fileUrls);
//            return ResponseEntity.ok(fileUrls);
//        } else {
//            adoptionReviewDto.setUserNo(userNo);
//            int result = adoptionService.writeArArticle(adoptionReviewDto, new ArrayList<>());
//            return ResponseEntity.ok("글만 저장");
//        }
//    }

    @PostMapping(value="/upload/adoption/review", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadMissFile(@RequestPart(value = "files", required = false) List<MultipartFile> multipartFiles, @ModelAttribute AdoptionReviewDto adoptionReviewDto, HttpSession session){
        Long userNo = (Long) session.getAttribute("userNo");
        List<S3ArFileDto> s3ArFileDtoList = new ArrayList<>();
        if(multipartFiles != null && !multipartFiles.isEmpty()){
            s3ArFileDtoList = awsS3ArService.uploadImageAdotion(multipartFiles);
            List<String> fileUrls = s3ArFileDtoList.stream().map(S3ArFileDto::getFileUrl).collect(Collectors.toList());
            adoptionReviewDto.setUserNo(userNo);
            int result = adoptionService.writeArArticle(adoptionReviewDto, fileUrls);
            return ResponseEntity.ok(fileUrls);
        } else {
            adoptionReviewDto.setUserNo(userNo);
            int result = adoptionService.writeArArticle(adoptionReviewDto, new ArrayList<>());
            return ResponseEntity.ok("글만 저장");
        }
    }

    @DeleteMapping("/delete/arImg")
    public ResponseEntity<?> deleteFile(@RequestParam("fileName") String fileName){
        String[] fileNames = fileName.split(",");

        for (String name : fileNames) {
            awsS3ArService.deleteFiles(name.trim()); // 파일 이름 앞뒤의 공백 제거
        }
        return ResponseEntity.ok(awsS3ArService.deleteFiles(fileName));
    }

    @PostMapping("/adoption/delete/{arNo}")
    @ResponseBody
    @Transactional
    public void deleteAdoption(@PathVariable Long arNo){
        adoptionService.removeReview(arNo);
    }


}
