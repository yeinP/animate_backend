package org.yeinp.animate.animate_backend.adoption.service;

import org.springframework.web.multipart.MultipartFile;
import org.yeinp.animate.animate_backend.adoption.dto.S3ArFileDto;
import org.yeinp.animate.animate_backend.miss.dto.S3MissFileDto;

import java.util.List;

public interface AwsS3ArService {
    List<S3ArFileDto> uploadImageAdotion(List<MultipartFile> multipartFiles);
    Object deleteFiles(String fileName);

    String getRenamedFileName(String originalFileName, int count);





}
