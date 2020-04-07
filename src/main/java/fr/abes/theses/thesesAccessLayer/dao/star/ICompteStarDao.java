package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.CompteStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompteStarDao extends JpaRepository<CompteStar, Integer> {
}
