package org.yeinp.animate.animate_backend.notice.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.entity.Notice;
import org.yeinp.animate.animate_backend.notice.dto.NoticeDto;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {

    @Query("SELECT new org.yeinp.animate.animate_backend.notice.dto.NoticeDto(" +
            "n.noticeNo, n.noticeTitle, n.noticeContent, n.noticeWriter, n.noticeCount, n.noticeRegdate, n.noticeStatus) " +
            "FROM Notice n " +
            "WHERE n.noticeStatus = 1 " +
            "ORDER BY n.noticeRegdate DESC")
    List<NoticeDto> getImpNoticeList();

    List<Notice> findAllByOrderByNoticeRegdateDesc();

    @Modifying
    @Query("UPDATE Notice n SET n.noticeCount = n.noticeCount + 1 WHERE n.noticeNo = :noticeNo")
    void increaseNoticeCount(@Param("noticeNo") Long noticeNo);
}
