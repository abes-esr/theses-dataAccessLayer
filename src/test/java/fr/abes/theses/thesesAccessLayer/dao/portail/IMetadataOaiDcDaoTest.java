package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataMarc;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataOaiDc;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordMarc;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordOaiDc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class IMetadataOaiDcDaoTest {
    private MetadataOaiDc metadataOaiDc;
    private OaiRecordOaiDc oaiRecordOaiDc;

    @Autowired
    private IOaiRecordOaiDcDao oaiRecordOaiDcDao;

    @Autowired
    private IMetadataOaiDcDao metadataOaiDcDao;

    @BeforeEach
    public void init() {
        this.oaiRecordOaiDc = new OaiRecordOaiDc();
        this.oaiRecordOaiDc.setOaiRecordId(1);
        this.oaiRecordOaiDc.setOaiIdentifier("test");
        this.oaiRecordOaiDc.setDateInsertion(new GregorianCalendar());
        this.oaiRecordOaiDcDao.save(this.oaiRecordOaiDc);

        this.metadataOaiDc = getMetadataOaiDc();
    }

    @AfterEach
    public void end(){
        metadataOaiDcDao.delete(this.metadataOaiDc);
        oaiRecordOaiDcDao.delete(this.oaiRecordOaiDc);
    }

    @Test
    @Transactional
    public void testfindById() {
        MetadataOaiDc metadataOaiDcIn = metadataOaiDcDao.save(this.metadataOaiDc);
        MetadataOaiDc metadataOaiDcOut = metadataOaiDcDao.findById(metadataOaiDcIn.getId()).get();
        assertThat(metadataOaiDcOut.getId()).isEqualTo(metadataOaiDcIn.getId());
        assertThat(metadataOaiDcOut.getMetadata()).isEqualTo(metadataOaiDcIn.getMetadata());
    }

    @Test
    @Transactional
    public void testSave() {
        MetadataOaiDc metadataOaiDc = metadataOaiDcDao.save(this.metadataOaiDc);
        assertThat(metadataOaiDc.getId()).isEqualTo(this.metadataOaiDc.getId());
        assertThat(metadataOaiDc.getMetadata()).isEqualTo(this.metadataOaiDc.getMetadata());
    }

    private MetadataOaiDc getMetadataOaiDc() {
        MetadataOaiDc metadataOaiDc = new MetadataOaiDc(this.oaiRecordOaiDc, "test");
        return metadataOaiDc;
    }
}
