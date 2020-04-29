package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.InitFormationStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInitFormationStepDao extends JpaRepository<InitFormationStep, Integer> {
}
