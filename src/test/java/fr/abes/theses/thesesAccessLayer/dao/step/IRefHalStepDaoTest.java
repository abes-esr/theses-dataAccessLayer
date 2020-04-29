package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.RefHalStar;
import fr.abes.theses.thesesAccessLayer.model.entities.step.RefHalStep;
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
public class IRefHalStepDaoTest {
    public RefHalStep refHal;

    @Autowired
    private IRefHalStepDao refHalDao;

    @BeforeEach
    public void init() {
        refHal = getRefHal();
    }

    @AfterEach
    public void end(){
        refHalDao.delete(refHal);
    }

    @Test
    public void testFindById() {
        RefHalStep refHalIn = refHalDao.save(refHal);
        RefHalStep refHalOut = refHalDao.findById(refHalIn.getId()).get();
        assertThat(refHalOut.getId()).isEqualTo(refHalIn.getId());
        assertThat(refHalOut.getNameLabo()).isEqualTo(refHalIn.getNameLabo());
    }

    @Test
    public void testSave() {
        RefHalStep refHalIn = refHalDao.save(refHal);
        assertThat(refHalIn.getId()).isEqualTo(refHal.getId());
        assertThat(refHalIn.getNameLabo()).isEqualTo(refHal.getNameLabo());
    }

    @Test
    public void deleteById() {
        RefHalStep compteIn = refHalDao.save(refHal);
        refHalDao.deleteById(compteIn.getId());
        assertThat(refHalDao.findById(compteIn.getId())).isEmpty();
    }

    private RefHalStep getRefHal() {
        RefHalStep refHal = new RefHalStep();
        refHal.setIdLabo(999999);
        refHal.setNameLabo("TEST");
        return refHal;
    }
}
