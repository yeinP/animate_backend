package org.yeinp.animate.animate_backend.adoption.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyReqDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReplyDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReqReplyDto;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionReplyRepository;
import org.yeinp.animate.animate_backend.adoption.repository.ArReReplyRepository;
import org.yeinp.animate.animate_backend.adoption.service.ArReplyService;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyReqDto;
import org.yeinp.animate.animate_backend.miss.dto.ReplyDto;

import java.util.List;

@Controller
@RequestMapping("/animate")
@CrossOrigin("http://localhost:3000")
public class ArReplyController {

    @Autowired
    ArReplyService arReplyService;

    @Autowired
    AdoptionReplyRepository adoptionReplyRepository;

    @Autowired
    ArReReplyRepository arReReplyRepository;

    @GetMapping("/adoption/review/reply/{arNo}")
    @ResponseBody
    public ResponseEntity<List<ArReqReplyDto>> getReplyByMcNo(@PathVariable Long arNo){
        List<ArReqReplyDto> replyDtoList = adoptionReplyRepository.listReply(arNo);
        return ResponseEntity.ok(replyDtoList);
    }

    @PostMapping("/adoption/review/reply")
    public ResponseEntity<Object> writeArReply(@ModelAttribute ArReplyDto arReplyDto, @RequestParam Long arNo,
                                               HttpSession session){
        try {
            Long userNo = (Long) session.getAttribute("userNo");

            if (userNo == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 로그인되지 않았습니다.");
            }
            arReplyDto.setReplyWriter(userNo);
            arReplyDto.setArNo(arNo);
            int result = arReplyService.writeArReply(arReplyDto);
            return ResponseEntity.ok("댓글 작성 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글 작성 중 오류가 발생했습니다.");
        }
    }

    @GetMapping("/adoption/review/reply/{arNo}/re")
    @ResponseBody
    public ResponseEntity<List<ArReReplyReqDto>> getReReplyByReplyNo(@PathVariable Long arNo){
        List<ArReReplyReqDto> reReplyDtoList = arReReplyRepository.listReReply(arNo);
        return ResponseEntity.ok(reReplyDtoList);
    }

    @PostMapping("/adoption/review/reply/re")
    public ResponseEntity<Object> writeReReply(@ModelAttribute ArReReplyDto arReReplyDto, @RequestParam Long arReplyNo, HttpSession session){
        try{
            Long userNo = (Long) session.getAttribute("userNo");

            if (userNo == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 로그인되지 않았습니다.");
            }
            arReReplyDto.setArReplyNo(arReplyNo);
            arReReplyDto.setArReReplyWriter(userNo);
            arReplyService.writeArReReply(arReReplyDto);
            return ResponseEntity.ok("답글 작성 성공");

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("답글 작성 중 오류가 발생했습니다." + e);
        }
    }
}
