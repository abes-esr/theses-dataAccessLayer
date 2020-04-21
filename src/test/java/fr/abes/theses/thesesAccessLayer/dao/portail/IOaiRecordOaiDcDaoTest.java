package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordOaiDc;
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
public class IOaiRecordOaiDcDaoTest {
    public OaiRecordOaiDc oaiRecordOaiDc;

    @Autowired
    private IOaiRecordOaiDcDao oaiRecordOaiDcDao;

    @BeforeEach
    public void init() {
        oaiRecordOaiDc = getOaiRecordOaiDc();
    }

    @AfterEach
    public void end(){
        oaiRecordOaiDcDao.delete(oaiRecordOaiDc);
    }

    @Test
    public void testfindById() {
        OaiRecordOaiDc oaiRecordIn = oaiRecordOaiDcDao.save(oaiRecordOaiDc);
        OaiRecordOaiDc oaiRecordOut = oaiRecordOaiDcDao.findById(oaiRecordIn.getId()).get();
        assertThat(oaiRecordOut.getId()).isEqualTo(oaiRecordIn.getId());
    }

    @Test
    public void testSave() {
        OaiRecordOaiDc oaiRecordIn = oaiRecordOaiDcDao.save(oaiRecordOaiDc);
        assertThat(oaiRecordIn.getId()).isEqualTo(oaiRecordOaiDc.getId());
        assertThat(oaiRecordIn.getDateInsertion()).isEqualTo(oaiRecordOaiDc.getDateInsertion());
    }

    @Test
    public void testDeleteById() {
        OaiRecordOaiDc oaiRecordIn = oaiRecordOaiDcDao.save(oaiRecordOaiDc);
        oaiRecordOaiDcDao.deleteById(oaiRecordIn.getId());
        assertThat(oaiRecordOaiDcDao.findById(oaiRecordIn.getId())).isEmpty();
    }

    private OaiRecordOaiDc getOaiRecordOaiDc() {
        OaiRecordOaiDc oaiRecordOaiDc = new OaiRecordOaiDc();
        oaiRecordOaiDc.setOaiRecordId(1);
        oaiRecordOaiDc.setOaiIdentifier("test");
        oaiRecordOaiDc.setDateInsertion(new GregorianCalendar());
        return oaiRecordOaiDc;
    }

}
