package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordMarc;
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
public class IOaiRecordMarcDaoTest {
    public OaiRecordMarc oaiRecordMarc;

    @Autowired
    private IOaiRecordMarcDao oaiRecordMarcDao;

    @BeforeEach
    public void init() {
        oaiRecordMarc = getOaiRecordMarc();
    }

    @AfterEach
    public void end(){
        oaiRecordMarcDao.delete(oaiRecordMarc);
    }

    @Test
    public void testfindById() {
        OaiRecordMarc oaiRecordIn = oaiRecordMarcDao.save(oaiRecordMarc);
        OaiRecordMarc oaiRecordOut = oaiRecordMarcDao.findById(oaiRecordIn.getId()).get();
        assertThat(oaiRecordOut.getId()).isEqualTo(oaiRecordIn.getId());
    }

    @Test
    public void testSave() {
        OaiRecordMarc oaiRecordIn = oaiRecordMarcDao.save(oaiRecordMarc);
        assertThat(oaiRecordIn.getId()).isEqualTo(oaiRecordMarc.getId());
        assertThat(oaiRecordIn.getDateInsertion()).isEqualTo(oaiRecordMarc.getDateInsertion());
    }

    @Test
    public void testDeleteById() {
        OaiRecordMarc oaiRecordIn = oaiRecordMarcDao.save(oaiRecordMarc);
        oaiRecordMarcDao.deleteById(oaiRecordIn.getId());
        assertThat(oaiRecordMarcDao.findById(oaiRecordIn.getId())).isEmpty();
    }

    private OaiRecordMarc getOaiRecordMarc() {
        OaiRecordMarc oaiRecordMarc = new OaiRecordMarc();
        oaiRecordMarc.setOaiRecordId(1);
        oaiRecordMarc.setOaiIdentifier("test");
        oaiRecordMarc.setDateInsertion(new GregorianCalendar());
        return oaiRecordMarc;
    }

}
