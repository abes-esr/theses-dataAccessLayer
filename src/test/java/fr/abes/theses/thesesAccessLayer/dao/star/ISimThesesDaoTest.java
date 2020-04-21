package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.SimTheses;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.jdom2.JDOMException;
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
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class ISimThesesDaoTest {
    private SimTheses simThese;

    @Autowired
    private ISimThesesDao simThesesDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException, JDOMException {
        simThese = getSimThese();
    }

    @AfterEach
    public void end() {
        simThesesDao.delete(simThese);
    }

    @Test
    public void testFindById() throws TransformerException {
        SimTheses simTheseIn = simThesesDao.save(simThese);
        SimTheses simTheseOut = simThesesDao.findById(simTheseIn.getId()).get();
        assertThat(simTheseOut.getCode()).isEqualTo(simTheseIn.getCode());
        assertThat(HibernateXMLType.domToString(simTheseOut.getFiche())).isEqualTo(HibernateXMLType.domToString(simTheseIn.getFiche()));
    }

    @Test
    public void testDeleteById() {
        SimTheses simTheseIn = simThesesDao.save(this.simThese);
        simThesesDao.deleteById(simTheseIn.getId());
        assertThat(simThesesDao.findById(simTheseIn.getId())).isEmpty();
    }

    private SimTheses getSimThese() throws IOException, SAXException, ParserConfigurationException, JDOMException {
        SimTheses simThese = new SimTheses();
        simThese.setCode("TEST");
        String filePath = getClass().getClassLoader().getResource("etablissement.xml").getPath();
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        simThese.setFiche(doc);
        return simThese;
    }

}
