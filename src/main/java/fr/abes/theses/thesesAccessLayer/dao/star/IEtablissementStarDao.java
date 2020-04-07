package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.EtablissementStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtablissementStarDao extends JpaRepository<EtablissementStar, String> {
}
