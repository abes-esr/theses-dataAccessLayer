package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetId;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetTef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecSetTefDao extends JpaRepository<RecSetTef, RecSetId> {
}
