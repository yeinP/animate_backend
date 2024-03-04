package org.yeinp.animate.animate_backend.miss.service;

import org.springframework.web.multipart.MultipartFile;
import org.yeinp.animate.animate_backend.miss.dto.S3MissFileDto;


import java.util.List;

public interface AwsS3MissService {
    List<S3MissFileDto> uploadImageMiss(List<MultipartFile> multipartFiles);
    Object deleteFiles(String fileName);

    String getRenamedFileName(String originalFileName, int count);






}
