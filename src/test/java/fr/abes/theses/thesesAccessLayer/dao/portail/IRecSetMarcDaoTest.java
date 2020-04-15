package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordMarc;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiSet;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.RecSetMarc;
import org.junit.jupiter.api.*;
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
public class IRecSetMarcDaoTest {
    private RecSetMarc recSetMarc;
    private OaiRecordMarc oaiRecordMarc;
    private OaiSet oaiSet;

    @Autowired
    private IOaiRecordMarcDao oaiRecordMarcDao;

    @Autowired
    private IOaiSetDao oaiSetDao;

    @Autowired
    private IRecSetMarcDao recSetMarcDao;

    @BeforeEach
    public void init() {
        this.recSetMarc = getRecSetMarc();

        this.oaiRecordMarc = new OaiRecordMarc();
        this.oaiRecordMarc.setOaiRecordId(1);
        this.oaiRecordMarc.setOaiIdentifier("test");
        this.oaiRecordMarc.setDateInsertion(new GregorianCalendar());
        this.oaiRecordMarcDao.save(this.oaiRecordMarc);

        this.oaiSet = new OaiSet();
        this.oaiSet.setSetSpec("test");
        this.oaiSet.setSetName("test");
        this.oaiSet.setSetId(99999);
        this.oaiSetDao.save(this.oaiSet);
    }

    @AfterEach
    public void end(){
        recSetMarcDao.delete(recSetMarc);
        oaiSetDao.delete(oaiSet);
        oaiRecordMarcDao.delete(oaiRecordMarc);
    }

    @Test
    public void testFindRecSetMarc() {
        RecSetMarc recSetMarcIn = recSetMarcDao.save(recSetMarc);
        RecSetMarc recSetMarcOut = recSetMarcDao.findById(recSetMarcIn.getId()).get();
        assertThat(recSetMarcOut.getId()).isEqualTo(recSetMarcIn.getId());
    }

    @Test
    public void testSaveRecSetMarc() {
        RecSetMarc recSetMarcIn = recSetMarcDao.save(this.recSetMarc);
        assertThat(recSetMarcIn.getId()).isEqualTo(this.recSetMarc.getId());
    }

    @Test
    public void deleteById() {
        RecSetMarc recSetMarcIn = recSetMarcDao.save(recSetMarc);
        recSetMarcDao.deleteById(recSetMarcIn.getId());
        assertThat(recSetMarcDao.findById(recSetMarcIn.getId())).isEmpty();
    }

    private RecSetMarc getRecSetMarc() {
        RecSetMarc recSetMarc = new RecSetMarc(this.oaiRecordMarc, this.oaiSet, new GregorianCalendar());
        return recSetMarc;
    }
}
