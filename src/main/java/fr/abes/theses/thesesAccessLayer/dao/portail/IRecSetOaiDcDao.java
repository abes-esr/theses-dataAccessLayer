package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetId;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetOaiDc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecSetOaiDcDao extends JpaRepository<RecSetOaiDc, RecSetId> {
}
