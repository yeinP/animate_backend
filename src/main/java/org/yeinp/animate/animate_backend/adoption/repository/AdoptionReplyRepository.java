package org.yeinp.animate.animate_backend.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.adoption.dto.ArReqReplyDto;
import org.yeinp.animate.animate_backend.entity.ArReply;
import org.yeinp.animate.animate_backend.entity.MisscareReply;
import org.yeinp.animate.animate_backend.miss.dto.ReplyDto;

import java.util.List;

@Repository
public interface AdoptionReplyRepository extends JpaRepository<ArReply, Long> {

    @Query("SELECT new org.yeinp.animate.animate_backend.adoption.dto.ArReqReplyDto" +
            "(a.arReplyNo, a.replyWriter, a.arNo, a.reply, a.replyDate, u.userNo, u.userNickname) " +
            "FROM ArReply AS a INNER JOIN User AS u ON u.userNo = a.replyWriter " +
            "WHERE a.arNo = :arNo")
    public List<ArReqReplyDto> listReply(Long arNo);


}
