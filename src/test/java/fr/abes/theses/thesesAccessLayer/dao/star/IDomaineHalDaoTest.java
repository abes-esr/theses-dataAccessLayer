package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DomaineHal;
import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
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
public class IDomaineHalDaoTest {
    private DomaineHal domaineHal;

    @Autowired
    private IDomaineHalDao domaineHalDao;

    @BeforeEach
    public void init() {
        domaineHal = getDomaineHal();
    }

    @AfterEach
    public void end(){
        domaineHalDao.delete(domaineHal);
    }

    @Test
    public void testFindById() {
        DomaineHal domaineHalIn = domaineHalDao.save(domaineHal);
        DomaineHal domaineHalOut = domaineHalDao.findById(domaineHalIn.getIdDomaine()).get();
        assertThat(domaineHalOut.getIdDomaine()).isEqualTo(domaineHalIn.getIdDomaine());
    }

    @Test
    public void testDeleteById() {
        DomaineHal domaineHalOut = domaineHalDao.save(domaineHal);
        domaineHalDao.deleteById(domaineHalOut.getId());
        assertThat(domaineHalDao.findById(domaineHalOut.getId())).isEmpty();
    }

    private DomaineHal getDomaineHal() {
        DomaineHal domaineHal = new DomaineHal();
        domaineHal.setIdDomaine(999999);
        domaineHal.setCode("CHIM");
        domaineHal.setLabel("Chemical Sciences");
        domaineHal.setHaveNext(true);
        domaineHal.setLevelDomaine("0");
        domaineHal.setParentId(1);
        return domaineHal;
    }
}
