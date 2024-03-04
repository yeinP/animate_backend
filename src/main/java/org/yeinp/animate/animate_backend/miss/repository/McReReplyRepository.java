package org.yeinp.animate.animate_backend.miss.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyReqDto;

import java.util.List;

public interface McReReplyRepository extends JpaRepository<McReReply, Long> {

    @Query("select new org.yeinp.animate.animate_backend.miss.dto.McReReplyReqDto" +
            "(r.reReplyNo, r.reReplyWriter, r.replyNo, r.reReplyDate, r.reReply, u.userNo, u.userNickname, r.mcNo) " +
            "From McReReply As r Inner Join User as u on u.userNo = r.reReplyWriter " +
            "where r.mcNo = :mcNo")
    public List<McReReplyReqDto> listReReply(@Param("mcNo") Long mcNo);


}
