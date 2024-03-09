package org.yeinp.animate.animate_backend.like.service;

import org.yeinp.animate.animate_backend.like.dto.LikesDto;
import org.yeinp.animate.animate_backend.entity.Likes;

public interface LikesService {

    int getLikeCount(Long arNo);

    int insertLike(LikesDto likesDto);

    void deleteLike(LikesDto likeDto);

    LikesDto getLikeByUserAndArNo(Long userNo, Long arNo);
    default LikesDto entityToLikesDto(Likes likes){
        return LikesDto.builder()
                .likeNo(likes.getLikeNo())
                .arNo(likes.getArNo())
                .userNo(likes.getUserNo()).likeStatus(likes.getLikeStatus())
                .build();
    }

    default Likes dtoToLikesEntity(LikesDto likesDto){
        return Likes.builder().
        likeNo(likesDto.getLikeNo()).
                arNo(likesDto.getArNo()).
                userNo(likesDto.getUserNo()).
                likeStatus(likesDto.getLikeStatus())
                .build();
    }
}
