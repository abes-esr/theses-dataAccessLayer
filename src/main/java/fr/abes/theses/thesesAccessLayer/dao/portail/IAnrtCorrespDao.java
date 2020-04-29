package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.AnrtCorresp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnrtCorrespDao extends JpaRepository<AnrtCorresp, Integer> {
}
