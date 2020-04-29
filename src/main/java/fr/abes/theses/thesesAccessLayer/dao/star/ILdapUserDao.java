package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.LdapUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILdapUserDao extends JpaRepository<LdapUser, String> {
}
