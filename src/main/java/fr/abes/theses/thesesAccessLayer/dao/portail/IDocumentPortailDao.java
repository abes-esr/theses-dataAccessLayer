package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.DocumentPortail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentPortailDao extends JpaRepository<DocumentPortail, Integer> {
}
