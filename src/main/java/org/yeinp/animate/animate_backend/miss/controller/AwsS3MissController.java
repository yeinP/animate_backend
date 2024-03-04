package org.yeinp.animate.animate_backend.miss.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;
import org.yeinp.animate.animate_backend.miss.dto.S3MissFileDto;
import org.yeinp.animate.animate_backend.miss.service.AwsS3MissService;
import org.yeinp.animate.animate_backend.miss.service.MissService;
import org.yeinp.animate.animate_backend.user.dto.UserDto;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/animate" )
@RequiredArgsConstructor
public class AwsS3MissController {
    private final AwsS3MissService awsS3MissService;

    @Autowired
    MissService missService;

    @PostMapping(value="/upload/mcAnimal", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadMissFile(@RequestParam(value = "files") List<MultipartFile> multipartFiles, @ModelAttribute MissCareDto missCareDto, HttpSession session){
        Long userNo = (Long) session.getAttribute("userNo");
        List<S3MissFileDto> s3MissFileDtoList = awsS3MissService.uploadImageMiss(multipartFiles);

        List<String> fileUrls = s3MissFileDtoList.stream().map(S3MissFileDto::getFileUrl).collect(Collectors.toList());
        missCareDto.setUserNo(userNo);
        int result = missService.writeMissArticle(missCareDto, fileUrls);
        return ResponseEntity.ok(fileUrls);
    }

    @DeleteMapping(value = "/delete/mcAnimalImg")
    public ResponseEntity<?> deleteFile(@RequestParam("fileName") String fileName){
        return ResponseEntity.ok(awsS3MissService.deleteFiles(fileName));
    }


}
