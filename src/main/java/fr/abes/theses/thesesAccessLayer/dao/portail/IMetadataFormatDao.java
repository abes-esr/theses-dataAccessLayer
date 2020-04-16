package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataFormat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMetadataFormatDao extends JpaRepository<MetadataFormat, Integer> {
}
