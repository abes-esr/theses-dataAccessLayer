package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.Courriel;
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
public class ICourrielDaoTest {
    public Courriel courriel;

    @Autowired
    private ICourrielDao CourrielDao;

    @BeforeEach
    public void init() {
        courriel = getcourriel();
    }

    @AfterEach
    public void end(){
        CourrielDao.delete(courriel);
    }

    @Test
    public void testfindById() {
        Courriel courrielIn = CourrielDao.save(courriel);
        Courriel courrielOut = CourrielDao.findById(courrielIn.getId()).get();
        assertThat(courrielOut.getId()).isEqualTo(courrielIn.getId());
    }

    @Test
    public void testSave() {
        Courriel courrielIn = CourrielDao.save(courriel);
        assertThat(courrielIn.getId()).isEqualTo(courriel.getId());
        assertThat(courrielIn.getDateEnvoi()).isEqualTo(courriel.getDateEnvoi());
    }

    @Test
    public void testDeleteById() {
        Courriel courrielIn = CourrielDao.save(courriel);
        CourrielDao.deleteById(courrielIn.getId());
        assertThat(CourrielDao.findById(courrielIn.getId())).isEmpty();
    }

    private Courriel getcourriel() {
        Courriel courriel = new Courriel();
        courriel.setDateEnvoi(new GregorianCalendar());
        return courriel;
    }

}
