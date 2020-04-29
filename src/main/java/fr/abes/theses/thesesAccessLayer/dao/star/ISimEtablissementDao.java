package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.SimEtablissemnt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISimEtablissementDao extends JpaRepository<SimEtablissemnt, String> {
}
