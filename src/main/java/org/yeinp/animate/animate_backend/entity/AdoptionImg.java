package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="ar_img")
public class AdoptionImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arImgNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ar_no")
    private AdoptionReview adoptionReview;

    private String arImgUrl;
}
