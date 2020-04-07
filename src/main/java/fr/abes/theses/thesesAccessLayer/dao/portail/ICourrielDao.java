package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.Courriel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourrielDao extends JpaRepository<Courriel, Integer> {
}
