package org.yeinp.animate.animate_backend.miss.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyReqDto;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;
import org.yeinp.animate.animate_backend.miss.service.MisscareReplyService;

@Controller
@RequestMapping("/animate")
@Slf4j
public class MisscareReplyController {
    @Autowired
    MisscareReplyService misscareReplyService;

    @PostMapping("/misscare/reply")
    public ResponseEntity<Object> writeMisscareReply(@ModelAttribute MisscareReplyDto misscareReplyDto,  @RequestParam Long mcNo,
                                                     HttpSession session){
        try {
            Long userNo = (Long) session.getAttribute("userNo");

            if (userNo == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 로그인되지 않았습니다.");
            }
            misscareReplyDto.setReplyWriter(userNo);
            misscareReplyDto.setMcNo(mcNo);
            int result = misscareReplyService.writeMisscareReply(misscareReplyDto);
            return ResponseEntity.ok("댓글 작성 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 작성 중 오류가 발생했습니다.");
        }
    }

    @PostMapping("/misscare/reply/re")
    public ResponseEntity<Object> writeReReply(@ModelAttribute McReReplyDto mcReReplyDto, @RequestParam Long replyNo, HttpSession session){
        try{
            Long userNo = (Long) session.getAttribute("userNo");

            if (userNo == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 로그인되지 않았습니다.");
            }
            mcReReplyDto.setReplyNo(replyNo);
            mcReReplyDto.setReReplyWriter(userNo);
            misscareReplyService.writeMcReReply(mcReReplyDto);
            return ResponseEntity.ok("답글 작성 성공");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("답글 작성 중 오류가 발생했습니다." + e);
        }
    }

}
