package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataOaiDc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetadataOaiDcDao extends JpaRepository<MetadataOaiDc, Integer> {
}
