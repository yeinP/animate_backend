package org.yeinp.animate.animate_backend.miss.repository;


import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.MissCare;
import org.yeinp.animate.animate_backend.miss.dto.MissCareDto;

import java.util.List;

@Repository
public interface MissRepository extends JpaRepository<MissCare, Long> {
    @Query("SELECT new org.yeinp.animate.animate_backend.miss.dto.MissCareDto(" +
            "m.mcNo, m.mcAddr, m.mcRegdate, m.mcStatus, m.userNo, m.mcLoc, " +
            "a.mcAnimalNo, a.mcBreed, a.mcGender, a.mcAge, a.mcWeight, " +
            "a.mcColor, a.mcChar, a.mcEtc, i.mcImgUrl) " +
            "FROM MissCare m " +
            "JOIN MissCareAnimal a ON m.mcNo = a.mcNo " +
            "LEFT JOIN m.missCareImgList i " +
            "WHERE (i.missCare.mcNo, i.mcImgNo) IN (" +
            "    SELECT mi.missCare.mcNo, MIN(mi.mcImgNo) " +
            "    FROM MissCareImg mi " +
            "    GROUP BY mi.missCare.mcNo" +
            ") ORDER BY m.mcRegdate DESC")
    List<MissCareDto> findMissCareDtoList();

    @Query("SELECT m.mcNo, m.mcAddr, m.mcRegdate, m.mcStatus, m.userNo, m.mcLoc, " +
            "a.mcBreed, a.mcGender, a.mcAge, a.mcWeight, a.mcColor, a.mcChar, a.mcEtc " +
            "FROM MissCare m JOIN MissCareAnimal a ON m.mcNo = a.mcNo WHERE m.mcNo = :mcNo")
    int missCareByMcNo(@Param("mcNo") int mcNo);
}