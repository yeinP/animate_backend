package org.yeinp.animate.animate_backend.miss.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.miss.dto.*;
import org.yeinp.animate.animate_backend.miss.repository.McReReplyRepository;
import org.yeinp.animate.animate_backend.miss.repository.MissRepository;
import org.yeinp.animate.animate_backend.miss.repository.MisscareReplyRepository;
import org.yeinp.animate.animate_backend.miss.service.MissService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin("http://localhost:3000")
public class MissController {
    @Autowired
    MissRepository missRepository;
    @Autowired
    MissService missService;
    @Autowired
    MisscareReplyRepository misscareReplyRepository;
    @Autowired
    McReReplyRepository mcReReplyRepository;



    @GetMapping("/animal/miss_care")
    @ResponseBody
    public List<MissCareDto> getMissCareDtoList(){
        return missRepository.findMissCareDtoList();
    }

    @GetMapping("/animal/miss_care/modal/{mcNo}")
    public ResponseEntity<List<MissCareImgDto>> getMissCareByMcNo(@PathVariable Long mcNo){
        List<MissCareImgDto> missCareImgDtoList = missService.mcImgUrlByMcNo(mcNo);
        return ResponseEntity.ok(missCareImgDtoList);
    }

    @GetMapping("/animal/miss_care/modal/{mcNo}/reply")
    public ResponseEntity<List<ReplyDto>> getReplyByMcNo(@PathVariable Long mcNo){
        List<ReplyDto> replyDtoList = misscareReplyRepository.listReply(mcNo);
        return ResponseEntity.ok(replyDtoList);
    }

    @GetMapping("/animal/miss_care/modal/{mcNo}/reply/re")
    public ResponseEntity<List<McReReplyReqDto>> getReReplyByReplyNo(@PathVariable Long mcNo){
        List<McReReplyReqDto> reReplyDtoList = mcReReplyRepository.listReReply(mcNo);
        return ResponseEntity.ok(reReplyDtoList);
    }




}
