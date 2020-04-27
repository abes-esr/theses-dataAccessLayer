package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.VerrouStar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableTransactionManagement
public class IVerrouStarDaoTest {
    public VerrouStar verrou;

    @Autowired
    private IVerrouStarDao verrouDao;

    @BeforeEach
    public void init() {
        verrou = getVerrou();
    }

    @AfterEach
    public void end(){
        verrouDao.delete(verrou);
    }

    @Test
    public void testFindById() {
        VerrouStar verrouIn = verrouDao.save(verrou);
        VerrouStar verrouOut = verrouDao.findById(verrouIn.getId()).get();
        assertThat(verrouOut.getId()).isEqualTo(verrouIn.getId());
        assertThat(verrouOut.getNomTable()).isEqualTo(verrouIn.getNomTable());
    }

    @Test
    public void testSave() {
        VerrouStar verrouIn = verrouDao.save(verrou);
        assertThat(verrouIn.getId()).isEqualTo(verrou.getId());
        assertThat(verrouIn.getNomTable()).isEqualTo(verrou.getNomTable());
    }

    @Test
    public void testDeleteById() {
        VerrouStar verrouIn = verrouDao.save(verrou);
        verrouDao.deleteById(verrouIn.getId());
        assertThat(verrouDao.findById(verrouIn.getId())).isEmpty();
    }

    private VerrouStar getVerrou() {
        VerrouStar verrou = new VerrouStar();
        verrou.setNomTable("TEST");
        return verrou;
    }
}
