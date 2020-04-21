package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.model.entities.step.DocIndexationSolr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocIndexationSolrDao extends JpaRepository<DocIndexationSolr, Integer> {
}
