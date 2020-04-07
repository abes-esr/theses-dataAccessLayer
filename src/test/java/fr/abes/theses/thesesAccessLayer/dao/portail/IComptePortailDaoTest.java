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

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IComptePortailDaoTest {
    public ComptePortail compte;

    @Autowired
    private IComptePortailDao compteDao;

    @BeforeEach
    public void init() {
        compte = getCompte();
    }

    @Test
    public void testFindCompte() {
        ComptePortail compteIn = compteDao.save(compte);
        ComptePortail compteOut = compteDao.findById(compteIn.getId()).get();
        assertThat(compteOut.getId().getIdCompte()).isEqualTo(compteIn.getId().getIdCompte());
        compteDao.deleteById(compteIn.getId());
    }

    private ComptePortail getCompte() {
        ComptePortail compte = new ComptePortail();
        compte.setEmail("test@test.fr");
        compte.setMdp("test");
        compte.setDtCrea(new GregorianCalendar());
        compte.setDtModif(new GregorianCalendar());
        return compte;
    }

}
