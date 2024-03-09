package org.yeinp.animate.animate_backend.like.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.Likes;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    @Query("SELECT COUNT(*) FROM Likes WHERE arNo = :arNo AND likeStatus = 'Y'")
    int selectLikeCount(@Param("arNo") Long arNo);
    Likes findByUserNoAndArNo(Long userNo, Long arNo);
}