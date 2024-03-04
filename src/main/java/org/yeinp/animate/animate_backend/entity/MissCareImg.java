package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="miss_img")
public class MissCareImg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcImgNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mc_no")
    private MissCare missCare;

    private String mcImgUrl;
}
