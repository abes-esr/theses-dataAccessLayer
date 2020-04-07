package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.step.VerrouStep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class IVerrouStepDaoTest {
    public VerrouStep verrou;

    @Autowired
    private IVerrouStepDao verrouDao;

    @BeforeEach
    public void init() {
        verrou = getVerrou();
    }

    @AfterEach
    public void end(){
        verrouDao.delete(verrou);
    }

    @Test
    public void testFindCompte() {
        VerrouStep verrouIn = verrouDao.save(verrou);
        VerrouStep verrouOut = verrouDao.findById(verrouIn.getId()).get();
        assertThat(verrouOut.getId()).isEqualTo(verrouIn.getId());
        assertThat(verrouOut.getNomTable()).isEqualTo(verrouIn.getNomTable());
    }

    @Test
    public void testSaveCompte() {
        VerrouStep verrouIn = verrouDao.save(verrou);
        assertThat(verrouIn.getId()).isEqualTo(verrou.getId());
        assertThat(verrouIn.getNomTable()).isEqualTo(verrou.getNomTable());
    }

    @Test
    public void deleteById() {
        VerrouStep verrouIn = verrouDao.save(verrou);
        verrouDao.deleteById(verrouIn.getId());
        assertThat(verrouDao.findById(verrouIn.getId())).isEmpty();
    }

    private VerrouStep getVerrou() {
        VerrouStep verrou = new VerrouStep();
        verrou.setNomTable("TEST");
        return verrou;
    }
}
