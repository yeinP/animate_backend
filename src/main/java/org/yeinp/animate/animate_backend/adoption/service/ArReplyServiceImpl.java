package org.yeinp.animate.animate_backend.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.adoption.dto.ArReReplyDto;
import org.yeinp.animate.animate_backend.adoption.dto.ArReplyDto;
import org.yeinp.animate.animate_backend.adoption.repository.AdoptionReplyRepository;
import org.yeinp.animate.animate_backend.adoption.repository.ArReReplyRepository;
import org.yeinp.animate.animate_backend.entity.ArReReply;
import org.yeinp.animate.animate_backend.entity.ArReply;
import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.entity.MisscareReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;
import org.yeinp.animate.animate_backend.miss.repository.McReReplyRepository;
import org.yeinp.animate.animate_backend.miss.repository.MisscareReplyRepository;

@Service
public class ArReplyServiceImpl implements ArReplyService {

    @Autowired
    AdoptionReplyRepository adoptionReplyRepository;

    @Autowired
    ArReReplyRepository arReReplyRepository;

    @Autowired
    McReReplyRepository mcReReplyRepository;

    @Override
    public int writeArReply(ArReplyDto arReplyDto) {

        ArReply entity = aRDtoToEntity(arReplyDto);
        adoptionReplyRepository.save(entity);

        return 0;
    }

    @Override
    public int writeArReReply(ArReReplyDto arReReplyDto) {
        ArReReply entity = arReReplyDtoToEntity(arReReplyDto);
        arReReplyRepository.save(entity);
        return 0;
    }
}
