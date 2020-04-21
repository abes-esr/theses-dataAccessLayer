package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.SimTheses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISimThesesDao extends JpaRepository<SimTheses, String> {
}
