package org.yeinp.animate.animate_backend.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.adoption.dto.AdoptionReviewReqDto;
import org.yeinp.animate.animate_backend.notice.dto.NoticeArticleDto;
import org.yeinp.animate.animate_backend.notice.dto.NoticeDto;
import org.yeinp.animate.animate_backend.notice.repository.NoticeRepository;
import org.yeinp.animate.animate_backend.notice.service.NoticeService;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("http://localhost:3000")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeRepository noticeRepository;
    @GetMapping("/notice/list")
    @ResponseBody
    public List<NoticeDto> getNoticeDtoList(){
        return noticeService.getNoticeList();
    }

    @GetMapping("/notice/list/top")
    @ResponseBody
    public List<NoticeDto> getNoticeDtoTopList(){
        return noticeRepository.getImpNoticeList();
    }

    @GetMapping("/notice/{noticeNo}")
    @ResponseBody
    public Optional<NoticeArticleDto> getNoticeArticle(@PathVariable Long noticeNo){
        return noticeService.getNoticeWithImages(noticeNo);
    }



}
