package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.ComptePortail;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IComptePortailDaoTest {
    public ComptePortail comptePortail;

    @Autowired
    private IComptePortailDao compteDao;

    @BeforeEach
    public void init() {
        comptePortail = getComptePortail();
    }

    @AfterEach
    public void end() { compteDao.delete(comptePortail);}
    @Test
    @Transactional
    public void testSave() {
        ComptePortail compteIn = compteDao.save(comptePortail);
        assertThat(compteIn.getEmail()).isEqualTo(comptePortail.getEmail());
        assertThat(compteIn.getMdp()).isEqualTo(comptePortail.getMdp());
    }

    @Test
    @Transactional
    public void testDeleteById() {
        ComptePortail comptePortailIn = compteDao.save(comptePortail);
        compteDao.deleteById(comptePortailIn.getId());
        assertThat(compteDao.findById(comptePortailIn.getId())).isEmpty();
    }

    @Test
    public void testFindById() {
        ComptePortail compteIn = compteDao.save(comptePortail);
        ComptePortail compteOut = compteDao.findById(compteIn.getId()).get();
        assertThat(compteOut.getId().getIdCompte()).isEqualTo(compteIn.getId().getIdCompte());
        compteDao.deleteById(compteIn.getId());
    }

    private ComptePortail getComptePortail() {
        ComptePortail compte = new ComptePortail();
        compte.setEmail("test@test.fr");
        compte.setMdp("test");
        compte.setDtCrea(new GregorianCalendar());
        compte.setDtModif(new GregorianCalendar());
        return compte;
    }

}
