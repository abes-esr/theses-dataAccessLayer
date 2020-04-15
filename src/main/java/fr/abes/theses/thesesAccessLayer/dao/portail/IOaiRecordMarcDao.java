package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordMarc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOaiRecordMarcDao extends JpaRepository<OaiRecordMarc, Integer> {
}
