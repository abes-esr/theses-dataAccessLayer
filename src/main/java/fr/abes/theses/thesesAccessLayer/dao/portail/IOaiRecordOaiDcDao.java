package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordOaiDc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOaiRecordOaiDcDao extends JpaRepository<OaiRecordOaiDc, Integer> {
}
