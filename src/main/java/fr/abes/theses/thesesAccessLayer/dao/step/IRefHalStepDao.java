package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.RefHalStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRefHalStepDao extends JpaRepository<RefHalStep, Integer> {
}
