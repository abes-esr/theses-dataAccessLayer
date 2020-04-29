package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.EtablissementStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtablissementStepDao extends JpaRepository<EtablissementStep, String> {
}
