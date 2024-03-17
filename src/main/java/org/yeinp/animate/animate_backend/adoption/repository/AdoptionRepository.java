package org.yeinp.animate.animate_backend.adoption.repository;


import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;
import org.yeinp.animate.animate_backend.home.dto.HomeARDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface AdoptionRepository extends JpaRepository<AdoptionReview, Long> {

    @Query("SELECT new org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto(" +
            "a.arNo, a.arRegdate, a.userNo, a.arTitle, a.arContent, u.userNickname) " +
            "FROM AdoptionReview a INNER JOIN User u ON u.userNo = a.userNo order by a.arRegdate desc")
    List<AdoptionReviewReqDto> getArList();


    @Query("SELECT new org.yeinp.animate.animate_backend.home.dto.HomeARDto(" +
            "ar.arNo, ar.arRegdate, ar.arTitle, ai.arImgUrl, COUNT(l)) " +
            "FROM AdoptionReview ar " +
            "JOIN ar.adoptionReviewImgList ai " +
            "LEFT JOIN Likes l ON ar.arNo = l.arNo " +
            "WHERE ai.arImgNo IN (" +
            "   SELECT MIN(ai2.arImgNo) " +
            "   FROM AdoptionImg ai2 " +
            "   WHERE ai2.adoptionReview.arNo = ar.arNo" +
            ") " +
            "GROUP BY ar.arNo, ar.arRegdate, ar.arTitle, ai.arImgUrl " +
            "ORDER BY COUNT(l) DESC")
    List<HomeARDto> findHomeARDtoListWithLimit();

    default List<HomeARDto> findTop3HomeARDtoList() {
        return findHomeARDtoListWithLimit().stream()
                .limit(3)
                .collect(Collectors.toList());
    }


}
