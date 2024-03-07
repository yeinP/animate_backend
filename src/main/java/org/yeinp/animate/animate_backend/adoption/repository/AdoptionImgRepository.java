package org.yeinp.animate.animate_backend.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.AdoptionImg;

import java.util.List;
@Repository
public interface AdoptionImgRepository extends JpaRepository<AdoptionImg, Long> {
    List<AdoptionImg> findAll();
}
