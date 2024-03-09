package org.yeinp.animate.animate_backend.like.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.entity.Likes;
import org.yeinp.animate.animate_backend.entity.MissCare;
import org.yeinp.animate.animate_backend.entity.MissCareAnimal;
import org.yeinp.animate.animate_backend.entity.MissCareImg;
import org.yeinp.animate.animate_backend.like.dto.LikesDto;
import org.yeinp.animate.animate_backend.like.repository.LikesRepository;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    LikesRepository likesRepository;

    @Override
    public int getLikeCount(Long arNo) {
        return likesRepository.selectLikeCount(arNo);
    }

    @Override
    public int insertLike(LikesDto likesDto) {
        Likes entity = dtoToLikesEntity(likesDto);
        likesRepository.save(entity);
        return 0;
    }

    @Override
    public LikesDto getLikeByUserAndArNo(Long userNo, Long arNo) {
        Likes like = likesRepository.findByUserNoAndArNo(userNo, arNo);
        if (like != null) {
            return LikesDto.builder()
                    .likeNo(like.getLikeNo())
                    .userNo(like.getUserNo())
                    .arNo(like.getArNo())
                    .likeStatus(like.getLikeStatus())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public void deleteLike(LikesDto likeDto) {
        Long likeNo = likeDto.getLikeNo();
        likesRepository.deleteById(likeNo);
    }


}