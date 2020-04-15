package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordTef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOaiRecordTefDao extends JpaRepository<OaiRecordTef, Integer> {
}
