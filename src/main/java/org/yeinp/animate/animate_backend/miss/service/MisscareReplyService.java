package org.yeinp.animate.animate_backend.miss.service;

import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.entity.MissCare;
import org.yeinp.animate.animate_backend.entity.MisscareReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;

import java.sql.Timestamp;
import java.util.Date;

public interface MisscareReplyService {

    int writeMisscareReply(MisscareReplyDto missCareReplyDto);

    int writeMcReReply(McReReplyDto McReReplyDto);


    default MisscareReply missReplyDtoToEntity(MisscareReplyDto misscareReplyDto){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        MisscareReply entity = MisscareReply.builder().replyNo(misscareReplyDto.getReplyNo()).
                replyWriter(misscareReplyDto.getReplyWriter()).
                mcNo(misscareReplyDto.getMcNo()).
                reply(misscareReplyDto.getReply()).
                replyDate(today).
                build();
        return entity;
    }

    default McReReply mcReReplyDtoToEntity(McReReplyDto mcReReplyDto ){
        Date date = new Date();
        Timestamp today = new Timestamp(date.getTime());
        McReReply entity = McReReply.builder().reReplyNo(mcReReplyDto.getReReplyNo()).reReplyWriter(mcReReplyDto.getReReplyWriter()).
                replyNo(mcReReplyDto.getReplyNo()).reReplyDate(today).reReply(mcReReplyDto.getReReply()).mcNo(mcReReplyDto.getMcNo()).
                build();
        return entity;
    }

    default MissCareDto entityToMissDto(MissCare missCare){
        MissCareDto missCareDto = MissCareDto.builder().mcNo(missCare.getMcNo()).
                mcRegdate(missCare.getMcRegdate()).
                mcStatus(missCare.getMcStatus()).
                userNo(missCare.getUserNo()).
                mcLoc(missCare.getMcLoc()).
                build();
        return missCareDto;
    }
}
