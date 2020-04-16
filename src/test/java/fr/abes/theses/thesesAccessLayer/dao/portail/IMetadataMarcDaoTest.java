package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataMarc;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiRecordMarc;
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
public class IMetadataMarcDaoTest {
    private MetadataMarc metadataMarc;
    private OaiRecordMarc oaiRecordMarc;

    @Autowired
    private IOaiRecordMarcDao oaiRecordMarcDao;

    @Autowired
    private IMetadataMarcDao metadataMarcDao;

    @BeforeEach
    public void init() {
        this.oaiRecordMarc = new OaiRecordMarc();
        this.oaiRecordMarc.setOaiRecordId(1);
        this.oaiRecordMarc.setOaiIdentifier("test");
        this.oaiRecordMarc.setDateInsertion(new GregorianCalendar());
        this.oaiRecordMarcDao.save(this.oaiRecordMarc);

        this.metadataMarc = getMetadataMarc();
    }

    @AfterEach
    public void end(){
        metadataMarcDao.delete(this.metadataMarc);
        oaiRecordMarcDao.delete(this.oaiRecordMarc);
    }

    @Test
    @Transactional
    public void testFindRecSetMarc() {
        MetadataMarc metadataMarcIn = metadataMarcDao.save(this.metadataMarc);
        MetadataMarc metadataMarcOut = metadataMarcDao.findById(metadataMarcIn.getId()).get();
        assertThat(metadataMarcOut.getId()).isEqualTo(metadataMarcIn.getId());
        assertThat(metadataMarcOut.getMetadata()).isEqualTo(metadataMarcIn.getMetadata());
    }

    @Test
    @Transactional
    public void testSaveRecSetMarc() {
        MetadataMarc metadataMarc = metadataMarcDao.save(this.metadataMarc);
        assertThat(metadataMarc.getId()).isEqualTo(this.metadataMarc.getId());
        assertThat(metadataMarc.getMetadata()).isEqualTo(this.metadataMarc.getMetadata());
    }

    private MetadataMarc getMetadataMarc() {
        MetadataMarc metadataMarc = new MetadataMarc(this.oaiRecordMarc, "test");
        return metadataMarc;
    }
}
