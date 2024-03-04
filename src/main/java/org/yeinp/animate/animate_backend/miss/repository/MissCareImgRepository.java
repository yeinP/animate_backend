package org.yeinp.animate.animate_backend.miss.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.yeinp.animate.animate_backend.entity.MissCareImg;

import java.util.List;

public interface MissCareImgRepository extends JpaRepository<MissCareImg, Long> {
    List<MissCareImg> findByMissCare_mcNo(Long mcNo);
}
