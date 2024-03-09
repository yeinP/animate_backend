package org.yeinp.animate.animate_backend.adoption.service;

import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReplyDto;
import org.yeinp.animate.animate_backend.entity.*;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;

import java.sql.Timestamp;
import java.util.Date;

public interface ArReplyService {

    int writeArReply(ArReplyDto arReplyDto);

    int writeArReReply(ArReReplyDto arReReplyDto);


    default ArReply aRDtoToEntity(ArReplyDto arReplyDto){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        ArReply entity = ArReply.builder().arReplyNo(arReplyDto.getArReplyNo()).
                replyWriter(arReplyDto.getReplyWriter()).
                arNo(arReplyDto.getArNo()).
                reply(arReplyDto.getReply()).
                replyDate(today).
                build();
        return entity;
    }

    default ArReReply arReReplyDtoToEntity(ArReReplyDto arReReplyDto ){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        ArReReply entity = ArReReply.builder().arReReplyNo(arReReplyDto.getArReReplyNo()).arReReplyWriter(arReReplyDto.getArReReplyWriter()).
                arReplyNo(arReReplyDto.getArReplyNo()).arReReplyDate(today).arReReply(arReReplyDto.getArReReply()).arNo(arReReplyDto.getArNo()).
                build();
        return entity;
    }

}
