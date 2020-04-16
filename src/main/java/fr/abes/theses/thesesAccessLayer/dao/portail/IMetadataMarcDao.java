package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataMarc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetadataMarcDao extends JpaRepository<MetadataMarc, Integer> {
}
