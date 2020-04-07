package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.RefHalStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRefHalStarDao extends JpaRepository<RefHalStar, Integer> {
}
