package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.DomaineHal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomaineHalDao extends JpaRepository<DomaineHal, Integer> {
}
