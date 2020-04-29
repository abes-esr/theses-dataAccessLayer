package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.VerrouStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVerrouStepDao extends JpaRepository<VerrouStep, Integer> {
}
