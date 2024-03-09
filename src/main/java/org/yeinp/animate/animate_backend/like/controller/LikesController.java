package org.yeinp.animate.animate_backend.like.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yeinp.animate.animate_backend.entity.Likes;
import org.yeinp.animate.animate_backend.like.dto.LikesDto;
import org.yeinp.animate.animate_backend.like.service.LikesService;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;

@Controller

@RequestMapping("/animate")
public class LikesController {
    @Autowired
    LikesService likesService;

    @GetMapping("/adoption/review/likecount/{arNo}")
    @ResponseBody
    public int adoptionLikeCount(@PathVariable Long arNo) {
        return likesService.getLikeCount(arNo);
    }
    
//    @PostMapping("/adoption/review/like")
//    public ResponseEntity<Object> insertLike(@ModelAttribute LikesDto likesDto, @RequestParam Long arNo,
//                                                     HttpSession session){
//        try {
//            Long userNo = (Long) session.getAttribute("userNo");
//            if (userNo == null) {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("세션이 만료되었거나 로그인되지 않았습니다.");
//            }
//
//            LikesDto existingLike = likesService.getLikeByUserAndArNo(userNo, arNo);
//
//
//
//            likesDto.setUserNo(userNo);
//            likesDto.setArNo(arNo);
//            likesDto.setLikeStatus('Y');
//            int result = likesService.insertLike(likesDto);
//            return ResponseEntity.ok("좋아요");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 오류");
//        }
//    }

    @RequestMapping(value = {"/adoption/review/like"}, method = {RequestMethod.POST})
    public ResponseEntity<Object> insertLike(@ModelAttribute LikesDto likesDto, @RequestParam Long arNo, HttpSession session) {
        try {
            Long userNo = (Long) session.getAttribute("userNo");


            LikesDto existingLike = likesService.getLikeByUserAndArNo(userNo, arNo);
            if (existingLike != null && existingLike.getLikeStatus() == 'Y') {

                likesService.deleteLike(existingLike);
                return ResponseEntity.ok("좋아요 취소");
            } else {
                likesDto.setUserNo(userNo);
                likesDto.setArNo(arNo);
                likesDto.setLikeStatus('Y');
                int result = likesService.insertLike(likesDto);
                return ResponseEntity.ok("좋아요");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 오류");
        }
    }

    @GetMapping("/adoption/review/like/{arNo}")
    public ResponseEntity<Object> getLikeStatus(@PathVariable Long arNo, HttpSession session) {
        try {
            Long userNo = (Long) session.getAttribute("userNo");

            LikesDto existingLike = likesService.getLikeByUserAndArNo(userNo, arNo);
            if (existingLike != null && existingLike.getLikeStatus() == 'Y') {
                return ResponseEntity.ok("Y");
            } else {
                return ResponseEntity.ok("N");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("좋아요 상태 조회 중 오류가 발생했습니다.");
        }
    }

}
