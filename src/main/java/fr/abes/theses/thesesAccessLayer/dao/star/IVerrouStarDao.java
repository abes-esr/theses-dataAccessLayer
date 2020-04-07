package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.VerrouStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVerrouStarDao extends JpaRepository<VerrouStar, Integer> {
}
