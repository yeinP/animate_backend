package org.yeinp.animate.animate_backend.miss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.MisscareReply;
import org.yeinp.animate.animate_backend.miss.dto.ReplyDto;

import java.util.List;

@Repository
public interface MisscareReplyRepository extends JpaRepository<MisscareReply, Long> {

    @Query("SELECT new org.yeinp.animate.animate_backend.miss.dto.ReplyDto" +
            "(r.replyNo, r.replyWriter, r.mcNo, r.reply, r.replyDate, u.userNo, u.userNickname) " +
            "FROM MisscareReply AS r INNER JOIN User AS u ON u.userNo = r.replyWriter " +
            "WHERE r.mcNo = :mcNo")
    public List<ReplyDto> listReply(Long mcNo);


}
