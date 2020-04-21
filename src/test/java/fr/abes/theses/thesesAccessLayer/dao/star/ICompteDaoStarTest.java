package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.CompteStar;
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
public class ICompteDaoStarTest {
    public CompteStar compte;

    @Autowired
    private ICompteStarDao compteDao;

    @BeforeEach
    public void init() {
        compte = getCompte();
    }

    @AfterEach
    public void end(){
        compteDao.delete(compte);
    }

    @Test
    public void testfindById() {
        CompteStar compteIn = compteDao.save(compte);
        CompteStar compteOut = compteDao.findById(compteIn.getId()).get();
        assertThat(compteOut.getId()).isEqualTo(compteIn.getId());
    }

    @Test
    public void testSave() {
        CompteStar compteIn = compteDao.save(compte);
        assertThat(compteIn.getId()).isEqualTo(compte.getId());
        assertThat(compteIn.getDtCrea()).isEqualTo(compte.getDtCrea());
    }

    @Test
    public void testDeleteById() {
        CompteStar compteIn = compteDao.save(compte);
        compteDao.deleteById(compteIn.getId());
        assertThat(compteDao.findById(compteIn.getId())).isEmpty();
    }

    private CompteStar getCompte() {
        CompteStar compte = new CompteStar();
        compte.setDtCrea(new GregorianCalendar());
        compte.setDtModif(new GregorianCalendar());
        return compte;
    }
}
