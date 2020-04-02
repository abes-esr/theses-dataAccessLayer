package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentDao extends JpaRepository<DocumentStar, Integer> {
}
