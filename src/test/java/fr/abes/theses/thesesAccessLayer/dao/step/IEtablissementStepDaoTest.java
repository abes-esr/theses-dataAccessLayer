package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.dao.star.IEtablissementStarDao;
import fr.abes.theses.thesesAccessLayer.model.entities.star.EtablissementStar;
import fr.abes.theses.thesesAccessLayer.model.entities.step.EtablissementStep;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IEtablissementStepDaoTest {
    private EtablissementStep etablissement;

    @Autowired
    private IEtablissementStepDao etablissementDao;

    @BeforeEach
    public void init() throws DocumentException {
        etablissement = getEtablissement();
    }

    @AfterEach
    public void end() {
        etablissementDao.delete(etablissement);
    }

    @Test
    public void testFindById() throws TransformerException {
        EtablissementStep etablissementIn = etablissementDao.save(etablissement);
        EtablissementStep etablissementout = etablissementDao.findById(etablissementIn.getId()).get();
        assertThat(etablissementout.getCode()).isEqualTo(etablissementIn.getCode());
        assertThat(HibernateXMLType.domToString(etablissementout.getFiche())).isEqualTo(HibernateXMLType.domToString(etablissementIn.getFiche()));
    }

    @Test
    public void testDeleteById() {
        EtablissementStep etablissementIn = etablissementDao.save(etablissement);
        etablissementDao.deleteById(etablissementIn.getId());
        assertThat(etablissementDao.findById(etablissementIn.getId())).isEmpty();
    }

    private EtablissementStep getEtablissement() throws DocumentException {
        EtablissementStep etablissement = new EtablissementStep();
        etablissement.setCode("TEST");
        String filePath = getClass().getClassLoader().getResource("etablissement.xml").getPath();
        File xmlfile = new File(filePath);
        SAXReader reader = new SAXReader();
        etablissement.setFiche(reader.read(xmlfile));
        return etablissement;
    }
}
