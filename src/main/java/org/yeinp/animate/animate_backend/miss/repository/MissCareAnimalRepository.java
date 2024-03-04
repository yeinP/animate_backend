package org.yeinp.animate.animate_backend.miss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.animate.animate_backend.entity.MissCareAnimal;
@Repository
public interface MissCareAnimalRepository extends JpaRepository<MissCareAnimal, Long> {

}
