package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordTef;
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
public class IOaiRecordTefDaoTest {
    public OaiRecordTef oaiRecordTef;

    @Autowired
    private IOaiRecordTefDao oaiRecordTefDao;

    @BeforeEach
    public void init() {
        oaiRecordTef = getOaiRecordTef();
    }

    @AfterEach
    public void end(){
        oaiRecordTefDao.delete(oaiRecordTef);
    }

    @Test
    public void testFindOaiRecord() {
        OaiRecordTef oaiRecordIn = oaiRecordTefDao.save(oaiRecordTef);
        OaiRecordTef oaiRecordOut = oaiRecordTefDao.findById(oaiRecordIn.getId()).get();
        assertThat(oaiRecordOut.getId()).isEqualTo(oaiRecordIn.getId());
    }

    @Test
    public void testSaveOaiRecord() {
        OaiRecordTef oaiRecordIn = oaiRecordTefDao.save(oaiRecordTef);
        assertThat(oaiRecordIn.getId()).isEqualTo(oaiRecordTef.getId());
        assertThat(oaiRecordIn.getDateInsertion()).isEqualTo(oaiRecordTef.getDateInsertion());
    }

    @Test
    public void deleteById() {
        OaiRecordTef oaiRecordIn = oaiRecordTefDao.save(oaiRecordTef);
        oaiRecordTefDao.deleteById(oaiRecordIn.getId());
        assertThat(oaiRecordTefDao.findById(oaiRecordIn.getId())).isEmpty();
    }

    private OaiRecordTef getOaiRecordTef() {
        OaiRecordTef oaiRecordTef = new OaiRecordTef();
        oaiRecordTef.setOaiRecordId(1);
        oaiRecordTef.setOaiIdentifier("test");
        oaiRecordTef.setDateInsertion(new GregorianCalendar());
        return oaiRecordTef;
    }

}
