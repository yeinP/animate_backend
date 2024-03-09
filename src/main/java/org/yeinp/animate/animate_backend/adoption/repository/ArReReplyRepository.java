package org.yeinp.animate.animate_backend.adoption.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyReqDto;
import org.yeinp.animate.animate_backend.entity.ArReReply;
import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyReqDto;

import java.util.List;

public interface ArReReplyRepository extends JpaRepository<ArReReply, Long> {

    @Query("select new org.yeinp.animate.animate_backend.adoption.dto.ArReReplyReqDto" +
            "(r.arReReplyNo, r.arReReplyWriter, r.arReplyNo, r.arReReplyDate, r.arReReply, u.userNo, u.userNickname, r.arNo) " +
            "From ArReReply As r Inner Join User as u on u.userNo = r.arReReplyWriter " +
            "where r.arNo = :arNo")
    public List<ArReReplyReqDto> listReReply(@Param("arNo") Long arNo);


}
