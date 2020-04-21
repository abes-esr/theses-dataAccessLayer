package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.SimRestiers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISimRestiersDao extends JpaRepository<SimRestiers, String> {
}
