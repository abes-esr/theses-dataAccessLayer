package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiSet;
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
public class IOaiSetDaoTest {
    public OaiSet oaiSet;

    @Autowired
    private IOaiSetDao oaiSetDao;

    @BeforeEach
    public void init() {
        oaiSet = getOaiSet();
    }

    @AfterEach
    public void end(){
        oaiSetDao.delete(oaiSet);
    }

    @Test
    public void testfindById() {
        OaiSet oaiSetIn = oaiSetDao.save(oaiSet);
        OaiSet oaiSetOut = oaiSetDao.findById(oaiSetIn.getId()).get();
        assertThat(oaiSetOut.getId()).isEqualTo(oaiSetIn.getId());
        assertThat(oaiSetOut.getSetName()).isEqualTo(oaiSetIn.getSetName());
    }

    @Test
    public void testSave() {
        OaiSet oaiSet = oaiSetDao.save(this.oaiSet);
        assertThat(oaiSet.getId()).isEqualTo(this.oaiSet.getId());
        assertThat(oaiSet.getSetName()).isEqualTo(this.oaiSet.getSetName());
    }

    @Test
    public void testDeleteById() {
        OaiSet oaiRecordIn = oaiSetDao.save(oaiSet);
        oaiSetDao.deleteById(oaiRecordIn.getId());
        assertThat(oaiSetDao.findById(oaiRecordIn.getId())).isEmpty();
    }

    private OaiSet getOaiSet() {
        OaiSet oaiSet = new OaiSet();
        oaiSet.setSetId(99999);
        oaiSet.setSetSpec("test");
        oaiSet.setSetName("test");
        return oaiSet;
    }
}
