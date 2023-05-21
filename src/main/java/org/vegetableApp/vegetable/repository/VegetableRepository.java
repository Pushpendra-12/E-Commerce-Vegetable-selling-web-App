package org.vegetableApp.vegetable.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetableApp.vegetable.model.VegetableDTO;
@Repository("vegetableRepository")
public interface VegetableRepository extends JpaRepository<VegetableDTO,Integer>{


}
