package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.CompteId;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.ComptePortail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComptePortailDao extends JpaRepository<ComptePortail, CompteId> {
}
