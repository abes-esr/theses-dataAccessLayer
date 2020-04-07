package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.step.CompteStep;
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
public class ICompteStepDaoTest {
    public CompteStep compte;

    @Autowired
    private ICompteStepDao compteDao;

    @BeforeEach
    public void init() {
        compte = getCompte();
    }

    @AfterEach
    public void end(){
        compteDao.delete(compte);
    }

    @Test
    public void testFindCompte() {
        CompteStep compteIn = compteDao.save(compte);
        CompteStep compteOut = compteDao.findById(compteIn.getId()).get();
        assertThat(compteOut.getId()).isEqualTo(compteIn.getId());
    }

    @Test
    public void testSaveCompte() {
        CompteStep compteIn = compteDao.save(compte);
        assertThat(compteIn.getId()).isEqualTo(compte.getId());
        assertThat(compteIn.getDtCrea()).isEqualTo(compte.getDtCrea());
    }

    @Test
    public void deleteById() {
        CompteStep compteIn = compteDao.save(compte);
        compteDao.deleteById(compteIn.getId());
        assertThat(compteDao.findById(compteIn.getId())).isEmpty();
    }

    private CompteStep getCompte() {
        CompteStep compte = new CompteStep();
        compte.setDtCrea(new GregorianCalendar());
        compte.setDtModif(new GregorianCalendar());
        return compte;
    }
}