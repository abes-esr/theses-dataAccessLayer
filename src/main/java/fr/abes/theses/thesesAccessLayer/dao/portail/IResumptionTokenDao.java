package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.ResumptionToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IResumptionTokenDao extends JpaRepository<ResumptionToken, String> {
}
