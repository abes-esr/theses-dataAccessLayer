package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.*;
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
public class IRecSetOaiDcDaoTest {
    private RecSetOaiDc recSetOaiDc;
    private OaiRecordOaiDc oaiRecordOaiDc;
    private OaiSet oaiSet;

    @Autowired
    private IOaiRecordOaiDcDao oaiRecordOaiDcDao;

    @Autowired
    private IOaiSetDao oaiSetDao;

    @Autowired
    private IRecSetOaiDcDao recSetOaiDcDao;

    @BeforeEach
    public void init() {
        this.oaiRecordOaiDc = new OaiRecordOaiDc();
        this.oaiRecordOaiDc.setOaiRecordId(1);
        this.oaiRecordOaiDc.setOaiIdentifier("test");
        this.oaiRecordOaiDc.setDateInsertion(new GregorianCalendar());
        this.oaiRecordOaiDcDao.save(this.oaiRecordOaiDc);

        this.oaiSet = new OaiSet();
        this.oaiSet.setSetSpec("test");
        this.oaiSet.setSetName("test");
        this.oaiSet.setSetId(99999);
        this.oaiSetDao.save(this.oaiSet);

        this.recSetOaiDc = getRecSetOaiDc();
    }

    @AfterEach
    public void end(){
        recSetOaiDcDao.delete(this.recSetOaiDc);
        oaiSetDao.delete(this.oaiSet);
        oaiRecordOaiDcDao.delete(this.oaiRecordOaiDc);
    }

    @Test
    public void testfindById() {
        RecSetOaiDc recSetMarcIn = recSetOaiDcDao.save(recSetOaiDc);
        RecSetOaiDc recSetMarcOut = recSetOaiDcDao.findById(recSetMarcIn.getId()).get();
        assertThat(recSetMarcOut.getId().getOaiRecordId()).isEqualTo(recSetMarcIn.getId().getOaiRecordId());
        assertThat(recSetMarcOut.getId().getSetId()).isEqualTo(recSetMarcIn.getId().getSetId());
        assertThat(recSetMarcOut.getDateInsertion()).isEqualTo(recSetMarcIn.getDateInsertion());
    }

    @Test
    public void testSave() {
        RecSetOaiDc recSetMarcIn = recSetOaiDcDao.save(this.recSetOaiDc);
        assertThat(recSetMarcIn.getId().getOaiRecordId()).isEqualTo(this.recSetOaiDc.getId().getOaiRecordId());
        assertThat(recSetMarcIn.getId().getSetId()).isEqualTo(this.recSetOaiDc.getId().getSetId());
        assertThat(recSetMarcIn.getDateInsertion()).isEqualTo(this.recSetOaiDc.getDateInsertion());
    }

    @Test
    public void testDeleteById() {
        RecSetOaiDc recSetMarcIn = recSetOaiDcDao.save(recSetOaiDc);
        recSetOaiDcDao.deleteById(recSetMarcIn.getId());
        assertThat(recSetOaiDcDao.findById(recSetMarcIn.getId())).isEmpty();
    }

    private RecSetOaiDc getRecSetOaiDc() {
        RecSetOaiDc recSetOaiDc = new RecSetOaiDc(this.oaiRecordOaiDc, this.oaiSet, new GregorianCalendar());
        return recSetOaiDc;
    }
}
