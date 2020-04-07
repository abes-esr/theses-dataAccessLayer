package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.InitFormationStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInitFormationStarDao extends JpaRepository<InitFormationStep, Integer> {
}
