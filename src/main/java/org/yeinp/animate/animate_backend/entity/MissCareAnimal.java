package org.yeinp.animate.animate_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(name="misscare_animal")
public class MissCareAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mcAnimalNo;

    private String mcBreed;
    private String mcGender;
    private int mcAge;
    private int mcWeight;
    private String mcColor;
    private String mcChar;
    private String mcEtc;
    private Long mcNo;

}
