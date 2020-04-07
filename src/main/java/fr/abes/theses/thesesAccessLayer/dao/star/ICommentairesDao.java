package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentairesDao extends JpaRepository<Commentaires, Integer> {
}
