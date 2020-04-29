package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.EtablissementPortail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtablissementPortailDao extends JpaRepository<EtablissementPortail, String> {
}
