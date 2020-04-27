package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.SimRestiers;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.jdom2.JDOMException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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
@DataJpaTest
@EnableTransactionManagement
public class ISimRestiersDaoTest {
    private SimRestiers restiers;

    @Autowired
    private ISimRestiersDao restiersDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException, JDOMException {
        restiers = getRestiers();
    }

    @AfterEach
    public void end() {
        restiersDao.delete(restiers);
    }

    @Test
    public void testFindById() throws TransformerException {
        SimRestiers restierIn = restiersDao.save(restiers);
        SimRestiers restierOut = restiersDao.findById(restierIn.getId()).get();
        assertThat(restierOut.getCode()).isEqualTo(restierIn.getCode());
        assertThat(HibernateXMLType.domToString(restierOut.getFiche())).isEqualTo(HibernateXMLType.domToString(restierIn.getFiche()));
    }

    @Test
    public void testDeleteById() {
        SimRestiers restierIn = restiersDao.save(restiers);
        restiersDao.deleteById(restierIn.getId());
        assertThat(restiersDao.findById(restierIn.getId())).isEmpty();
    }

    private SimRestiers getRestiers() throws IOException, SAXException, ParserConfigurationException, JDOMException {
        SimRestiers simRestiers = new SimRestiers();
        simRestiers.setCode("TEST");
        String filePath = getClass().getClassLoader().getResource("etablissement.xml").getPath();
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        simRestiers.setFiche(doc);
        return simRestiers;
    }

}
