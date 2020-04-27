package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.LdapUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
@Disabled
public class ILdapUserDaoTest {
    public LdapUser ldapUser;

    @Autowired
    private ILdapUserDao ldapUserDao;

    @BeforeEach
    public void init() {
        ldapUser = getLdapUser();
    }

    @AfterEach
    public void end(){
        ldapUserDao.delete(ldapUser);
    }

    @Test
    public void testFindById() {
        LdapUser ldapUserIn = ldapUserDao.save(ldapUser);
        LdapUser ldapUserOut = ldapUserDao.findById(ldapUserIn.getId()).get();
        assertThat(ldapUserOut.getId()).isEqualTo(ldapUserIn.getId());
        assertThat(ldapUserIn.getCn()).isEqualTo(ldapUser.getCn());
        assertThat(ldapUserIn.getOu()).isEqualTo(ldapUser.getOu());
    }

    @Test
    public void testSave() {
        LdapUser ldapUserIn = ldapUserDao.save(ldapUser);
        assertThat(ldapUserIn.getId()).isEqualTo(ldapUser.getId());
        assertThat(ldapUserIn.getCn()).isEqualTo(ldapUser.getCn());
        assertThat(ldapUserIn.getOu()).isEqualTo(ldapUser.getOu());
    }

    @Test
    public void testDeleteById() {
        LdapUser ldapUserIn = ldapUserDao.save(ldapUser);
        ldapUserDao.deleteById(ldapUserIn.getId());
        assertThat(ldapUserDao.findById(ldapUserIn.getId())).isEmpty();
    }

    private LdapUser getLdapUser() {
        LdapUser ldapUser = new LdapUser();
        ldapUser.setDn("CN=test,OU=TEST,OU=TEST,DC=TEST,DC=TEST");
        ldapUser.setCn("test");
        ldapUser.setOu("TEST");
        return ldapUser;
    }
}
