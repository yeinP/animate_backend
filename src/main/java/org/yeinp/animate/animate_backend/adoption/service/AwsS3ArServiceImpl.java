package org.yeinp.animate.animate_backend.adoption.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.yeinp.animate.animate_backend.adoption.dto.S3ArFileDto;
import org.yeinp.animate.animate_backend.miss.dto.S3MissFileDto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AwsS3ArServiceImpl implements AwsS3ArService {
    private final AmazonS3Client amazonS3Client;
    ;

    @Value("${cloud.aws.s3.bucket2}")
    private String bucket2;

    @Override
    public List<S3ArFileDto> uploadImageAdotion(List<MultipartFile> multipartFiles) {

        List<S3ArFileDto> s3ArFiles = new ArrayList<>();
        int count = 1;

        for (MultipartFile multipartFile : multipartFiles) {
            String originalFileName = multipartFile.getOriginalFilename();

            String renamedFileName = getRenamedFileName(originalFileName, count);
            count++;
            String fileUrl = "";

            try {
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType(multipartFile.getContentType());
                metadata.setContentLength(multipartFile.getSize());
                amazonS3Client.putObject(bucket2, renamedFileName, multipartFile.getInputStream(), metadata);
                fileUrl = amazonS3Client.getUrl(bucket2, renamedFileName).toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            s3ArFiles.add(S3ArFileDto.builder().originFileName(originalFileName).renamedFileName(renamedFileName).fileUrl(fileUrl).build());
        }
        return s3ArFiles;
    }

    @Override
    public Object deleteFiles(String fileName) {
        String result = "delete file";

        boolean isObjectExist = amazonS3Client.doesObjectExist(bucket2, fileName);
        if(isObjectExist){
            amazonS3Client.deleteObject(bucket2, fileName);
        }else {
            result = "file not found";
        }
        return result;
    }

    @Override
    public String getRenamedFileName(String originalFileName, int count) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        Date date = new Date();
        String str = sdf.format(date);

        String ext = originalFileName.substring(originalFileName.indexOf(".") + 1);
        String renamedFileName = originalFileName.replaceAll(originalFileName, str) + "_" + String.format("%02d",count) + "."+ext;

        return renamedFileName;
    }



}

