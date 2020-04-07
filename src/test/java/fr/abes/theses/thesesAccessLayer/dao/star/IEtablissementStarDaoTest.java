package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.EtablissementStar;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IEtablissementStarDaoTest {
    private EtablissementStar etablissement;

    @Autowired
    private IEtablissementStarDao etablissementDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException {
        etablissement = getEtablissement();
    }

    @AfterEach
    public void end() {
        etablissementDao.delete(etablissement);
    }

    @Test
    public void findEtablissementTest() {
        EtablissementStar etablissementIn = etablissementDao.save(etablissement);
        EtablissementStar etablissementout = etablissementDao.findById(etablissementIn.getId()).get();
        assertThat(etablissementout.getCode()).isEqualTo(etablissementIn.getCode());
        assertThat(etablissementout.getFiche()).isEqualTo(etablissementIn.getFiche());
    }

    private EtablissementStar getEtablissement() throws IOException, SAXException, ParserConfigurationException {
        EtablissementStar etablissement = new EtablissementStar();
        etablissement.setCode("TEST");
        File xml = new File(getClass().getClassLoader().getResource("etablissement.xml").getPath());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(xml) ;
        etablissement.setFiche(doc.toString());
        return etablissement;
    }
}
