package org.yeinp.animate.animate_backend.miss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.animate.animate_backend.entity.McReReply;
import org.yeinp.animate.animate_backend.entity.MisscareReply;
import org.yeinp.animate.animate_backend.miss.dto.McReReplyDto;
import org.yeinp.animate.animate_backend.miss.dto.MisscareReplyDto;
import org.yeinp.animate.animate_backend.miss.repository.McReReplyRepository;
import org.yeinp.animate.animate_backend.miss.repository.MisscareReplyRepository;

@Service
public class MisscareReplyServiceImpl implements MisscareReplyService{

    @Autowired
    MisscareReplyRepository misscareReplyRepository;

    @Autowired
    McReReplyRepository mcReReplyRepository;

    @Override
    public int writeMisscareReply(MisscareReplyDto missCareReplyDto) {

        MisscareReply entity = missReplyDtoToEntity(missCareReplyDto);
        misscareReplyRepository.save(entity);

        return 0;
    }

    @Override
    public int writeMcReReply(McReReplyDto McReReplyDto) {
        McReReply entity = mcReReplyDtoToEntity(McReReplyDto);
        mcReReplyRepository.save(entity);
        return 0;
    }
}
