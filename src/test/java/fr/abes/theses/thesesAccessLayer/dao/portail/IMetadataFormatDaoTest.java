package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.MetadataFormat;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.OaiSet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IMetadataFormatDaoTest {
    public MetadataFormat metadataFormat;

    @Autowired
    private IMetadataFormatDao metadataFormatDao;

    @BeforeEach
    public void init() {
        metadataFormat = getOaiSet();
    }

    @AfterEach
    public void end(){
        metadataFormatDao.delete(metadataFormat);
    }

    @Test
    public void testfindById() {
        MetadataFormat metadataFormatIn = metadataFormatDao.save(this.metadataFormat);
        MetadataFormat metadataFormatOut = metadataFormatDao.findById(metadataFormatIn.getId()).get();
        assertThat(metadataFormatOut.getId()).isEqualTo(metadataFormatIn.getId());
        assertThat(metadataFormatOut.getMetadataPrefix()).isEqualTo(metadataFormatIn.getMetadataPrefix());
        assertThat(metadataFormatOut.getMetaNamespace()).isEqualTo(metadataFormatIn.getMetaNamespace());
        assertThat(metadataFormatOut.getMetaSchema()).isEqualTo(metadataFormatIn.getMetaSchema());
        assertThat(metadataFormatOut.isVisible()).isEqualTo(metadataFormatIn.isVisible());
    }

    @Test
    public void testSave() {
        MetadataFormat metadataFormat = metadataFormatDao.save(this.metadataFormat);
        assertThat(metadataFormat.getId()).isEqualTo(this.metadataFormat.getId());
        assertThat(metadataFormat.getMetadataPrefix()).isEqualTo(this.metadataFormat.getMetadataPrefix());
        assertThat(metadataFormat.getMetaSchema()).isEqualTo(this.metadataFormat.getMetaSchema());
        assertThat(metadataFormat.getMetaNamespace()).isEqualTo(this.metadataFormat.getMetaNamespace());
        assertThat(metadataFormat.isVisible()).isEqualTo(this.metadataFormat.isVisible());
    }

    @Test
    public void testDeleteById() {
        MetadataFormat metadataFormatIn = metadataFormatDao.save(metadataFormat);
        metadataFormatDao.deleteById(metadataFormatIn.getId());
        assertThat(metadataFormatDao.findById(metadataFormatIn.getId())).isEmpty();
    }

    private MetadataFormat getOaiSet() {
        MetadataFormat metadataFormat = new MetadataFormat();
        metadataFormat.setPrefixId(1000);
        metadataFormat.setMetadataPrefix("test");
        metadataFormat.setMetaSchema("http://www.test.fr");
        metadataFormat.setMetaNamespace("http://www.test.fr");
        metadataFormat.setVisible(true);
        return metadataFormat;
    }
}
