package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.DocumentStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentStepDao extends JpaRepository<DocumentStep, Integer> {
}
