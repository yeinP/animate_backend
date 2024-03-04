package org.yeinp.animate.animate_backend.miss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.entity.MissCare;
import org.yeinp.animate.animate_backend.entity.MissCareAnimal;
import org.yeinp.animate.animate_backend.entity.MissCareImg;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareImgDto;
import org.yeinp.animate.animate_backend.miss.dto.ReplyDto;
import org.yeinp.animate.animate_backend.miss.repository.MissCareAnimalRepository;
import org.yeinp.animate.animate_backend.miss.repository.MissCareImgRepository;
import org.yeinp.animate.animate_backend.miss.repository.MissRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissServiceImpl implements MissService {

    @Autowired
    MissRepository missRepository;

    @Autowired
    MissCareAnimalRepository missCareAnimalRepository;

    @Autowired
    MissCareImgRepository missCareImgRepository;


    @Autowired
    AwsS3MissService awsS3MissService;
    @Override
    public int writeMissArticle(MissCareDto missCareDto, List<String> imageUrls) {
        MissCare entity = missDtoToEntity(missCareDto);
        List<MissCareImg> missCareImgs = new ArrayList<>();

        for (String imageUrl : imageUrls) {
            missCareImgs.add(MissCareImg.builder().missCare(entity).mcImgUrl(imageUrl).build());
        }

        entity.setMissCareImgList(missCareImgs);
        missRepository.save(entity);

        MissCareAnimal animalEntity = missCareAnimalDtoToEntity(missCareDto, entity.getMcNo());
        missCareAnimalRepository.save(animalEntity);
        return 0;
    }

    @Override
    public List<MissCareImgDto> mcImgUrlByMcNo(Long mcNo) {
        List<MissCareImg> resultList = missCareImgRepository.findByMissCare_mcNo(mcNo);
        return resultList.stream()
                .map(this::entityToMissCareImgDto)
                .collect(Collectors.toList());

    }
}
