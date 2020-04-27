package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataTef;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordTef;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
@Disabled
public class IMetadataTefDaoTest {
    private MetadataTef metadataTef;
    private OaiRecordTef oaiRecordTef;

    @Autowired
    private IOaiRecordTefDao oaiRecordTefDao;

    @Autowired
    private IMetadataTefDao metadataTefDao;

    @BeforeEach
    public void init() {
        this.oaiRecordTef = new OaiRecordTef();
        this.oaiRecordTef.setOaiRecordId(1);
        this.oaiRecordTef.setOaiIdentifier("test");
        this.oaiRecordTef.setDateInsertion(new GregorianCalendar());
        this.oaiRecordTefDao.save(this.oaiRecordTef);

        this.metadataTef = getMetadataTef();
    }

    @AfterEach
    public void end(){
        metadataTefDao.delete(this.metadataTef);
        oaiRecordTefDao.delete(this.oaiRecordTef);
    }

    @Test
    @Transactional
    public void testfindById() {
        MetadataTef metadataTefIn = metadataTefDao.save(this.metadataTef);
        MetadataTef metadataTefOut = metadataTefDao.findById(metadataTefIn.getId()).get();
        assertThat(metadataTefOut.getId()).isEqualTo(metadataTefIn.getId());
        assertThat(metadataTefOut.getMetadata()).isEqualTo(metadataTefIn.getMetadata());
    }

    @Test
    @Transactional
    public void testSave() {
        MetadataTef metadataTef = metadataTefDao.save(this.metadataTef);
        assertThat(metadataTef.getId()).isEqualTo(this.metadataTef.getId());
        assertThat(metadataTef.getMetadata()).isEqualTo(this.metadataTef.getMetadata());
    }

    private MetadataTef getMetadataTef() {
        MetadataTef metadataTef = new MetadataTef(this.oaiRecordTef, "test");
        return metadataTef;
    }

}
