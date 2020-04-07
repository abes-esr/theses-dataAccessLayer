package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.ResumptionToken;
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
public class IResumptionTokenDaoTest {
    public ResumptionToken resumptionToken;

    @Autowired
    private IResumptionTokenDao resumptionTokenDao;

    @BeforeEach
    public void init() {
        resumptionToken = getresumptionToken();
    }

    @Test
    public void testFindCompte() {
        ResumptionToken resumptionTokenIn = resumptionTokenDao.save(resumptionToken);
        ResumptionToken resumptionTokenOut = resumptionTokenDao.findById(resumptionTokenIn.getId()).get();
        assertThat(resumptionTokenOut.getId()).isEqualTo(resumptionTokenIn.getId());
        assertThat(resumptionTokenOut.getResumptionToken()).isEqualTo(resumptionTokenIn.getResumptionToken());
        resumptionTokenDao.delete(resumptionToken);
    }

    @Test
    public void testSaveCompte() {
        ResumptionToken resumptionTokenIn = resumptionTokenDao.save(resumptionToken);
        assertThat(resumptionTokenIn.getId()).isEqualTo(resumptionToken.getId());
        assertThat(resumptionTokenIn.getResumptionToken()).isEqualTo(resumptionToken.getResumptionToken());
        resumptionTokenDao.delete(resumptionToken);
    }

    @Test
    public void deleteById() {
        ResumptionToken resumptionTokenIn = resumptionTokenDao.save(resumptionToken);
        resumptionTokenDao.deleteById(resumptionTokenIn.getId());
        assertThat(resumptionTokenDao.findById(resumptionTokenIn.getId())).isEmpty();
    }

    private ResumptionToken getresumptionToken() {
        ResumptionToken resumptionToken = new ResumptionToken();
        resumptionToken.setResumptionToken("1234567891234");
        resumptionToken.setVerb("ListIdentifiers");
        resumptionToken.setExpirationDate(new GregorianCalendar());
        resumptionToken.setSetId(0);
        resumptionToken.setPreviousRecordId(100);
        return resumptionToken;
    }
}
