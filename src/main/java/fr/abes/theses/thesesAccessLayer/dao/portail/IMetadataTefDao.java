package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataTef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetadataTefDao extends JpaRepository<MetadataTef, Integer> {
}
