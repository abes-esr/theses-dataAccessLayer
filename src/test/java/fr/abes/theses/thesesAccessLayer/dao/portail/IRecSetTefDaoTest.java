package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordTef;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiSet;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetTef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableTransactionManagement
public class IRecSetTefDaoTest {
    private RecSetTef recSetTef;
    private OaiRecordTef oaiRecordTef;
    private OaiSet oaiSet;

    @Autowired
    private IOaiRecordTefDao oaiRecordTefDao;

    @Autowired
    private IOaiSetDao oaiSetDao;

    @Autowired
    private IRecSetTefDao recSetTefDao;

    @BeforeEach
    public void init() {
        this.oaiRecordTef = new OaiRecordTef();
        this.oaiRecordTef.setOaiRecordId(1);
        this.oaiRecordTef.setOaiIdentifier("test");
        this.oaiRecordTef.setDateInsertion(new GregorianCalendar());
        this.oaiRecordTefDao.save(this.oaiRecordTef);

        this.oaiSet = new OaiSet();
        this.oaiSet.setSetSpec("test");
        this.oaiSet.setSetName("test");
        this.oaiSet.setSetId(99999);
        this.oaiSetDao.save(this.oaiSet);

        this.recSetTef = getRecSetTef();
    }

    @AfterEach
    public void end(){
        recSetTefDao.delete(this.recSetTef);
        oaiSetDao.delete(this.oaiSet);
        oaiRecordTefDao.delete(this.oaiRecordTef);
    }

    @Test
    public void testfindById() {
        RecSetTef recSetMarcIn = recSetTefDao.save(recSetTef);
        RecSetTef recSetMarcOut = recSetTefDao.findById(recSetMarcIn.getId()).get();
        assertThat(recSetMarcOut.getId().getOaiRecordId()).isEqualTo(recSetMarcIn.getId().getOaiRecordId());
        assertThat(recSetMarcOut.getId().getSetId()).isEqualTo(recSetMarcIn.getId().getSetId());
        assertThat(recSetMarcOut.getDateInsertion()).isEqualTo(recSetMarcIn.getDateInsertion());
    }

    @Test
    public void testSave() {
        RecSetTef recSetMarcIn = recSetTefDao.save(this.recSetTef);
        assertThat(recSetMarcIn.getId().getOaiRecordId()).isEqualTo(this.recSetTef.getId().getOaiRecordId());
        assertThat(recSetMarcIn.getId().getSetId()).isEqualTo(this.recSetTef.getId().getSetId());
        assertThat(recSetMarcIn.getDateInsertion()).isEqualTo(this.recSetTef.getDateInsertion());
    }

    @Test
    public void testDeleteById() {
        RecSetTef recSetMarcIn = recSetTefDao.save(recSetTef);
        recSetTefDao.deleteById(recSetMarcIn.getId());
        assertThat(recSetTefDao.findById(recSetMarcIn.getId())).isEmpty();
    }

    private RecSetTef getRecSetTef() {
        RecSetTef recSetTef = new RecSetTef(this.oaiRecordTef, this.oaiSet, new GregorianCalendar());
        return recSetTef;
    }
}
