package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.CompteStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteStepDao extends JpaRepository<CompteStep, Integer> {
}
