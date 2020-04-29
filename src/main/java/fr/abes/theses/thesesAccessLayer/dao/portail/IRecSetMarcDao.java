package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetId;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetMarc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecSetMarcDao extends JpaRepository<RecSetMarc, RecSetId> {
}
