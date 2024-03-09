package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "adoption_review")
public class AdoptionReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long arNo;

    private Timestamp arRegdate;

    private Long userNo;

    private String arTitle;

    private String arContent;


    @OneToMany(mappedBy = "adoptionReview", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdoptionImg> adoptionReviewImgList;
}
