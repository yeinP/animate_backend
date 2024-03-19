package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="misscare")
public class MissCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcNo;
    private String mcAddr;
    private Timestamp mcRegdate;
    private int mcStatus;
    private Long userNo;
    private String mcLoc;
    private String mcLoc2;

    @OneToMany(mappedBy = "missCare", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MissCareImg> missCareImgList;

}