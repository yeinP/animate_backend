package org.yeinp.animate.animate_backend.adoption.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewDto;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.entity.AdoptionReview;

import java.util.List;

@Repository
public interface AdoptionRepository extends JpaRepository<AdoptionReview, Long> {

    @Query("SELECT new org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto(" +
            "a.arNo, a.arRegdate, a.userNo, a.arTitle, a.arContent, u.userNickname) " +
            "FROM AdoptionReview a INNER JOIN User u ON u.userNo = a.userNo")
    List<AdoptionReviewReqDto> getArList();

}
