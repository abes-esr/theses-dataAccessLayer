package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOaiSetDao extends JpaRepository<OaiSet, Integer> {
}
