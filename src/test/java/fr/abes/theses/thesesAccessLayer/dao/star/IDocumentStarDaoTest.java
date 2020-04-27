package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.dao.step.IDocumentStepDao;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import fr.abes.theses.thesesAccessLayer.model.entities.star.EtablissementStar;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.jdom2.JDOMException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableTransactionManagement
public class IDocumentStarDaoTest {
    private DocumentStar documentStar;

    @Autowired
    private IDocumentStarDao documentStarDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException, JDOMException {
        documentStar = getDocumentStar();
    }

    @AfterEach
    public void end() {
        documentStarDao.delete(documentStar);
    }

    @Test
    public void testfindById() throws TransformerException {
        DocumentStar documentIn = documentStarDao.save(documentStar);
        DocumentStar documentOut = documentStarDao.findById(documentIn.getId()).get();
        assertThat(documentOut.getEnvoiSolr()).isEqualTo(documentIn.getEnvoiSolr());
        assertThat(HibernateXMLType.domToString(documentOut.getDoc())).isEqualTo(HibernateXMLType.domToString(documentIn.getDoc()));
    }

    @Test
    public void testDeleteById() {
        DocumentStar documentStarIn = documentStarDao.save(documentStar);
        documentStarDao.deleteById(documentStarIn.getId());
        assertThat(documentStarDao.findById(documentStarIn.getId())).isEmpty();
    }

    private DocumentStar getDocumentStar() throws IOException, SAXException, ParserConfigurationException, JDOMException {
        DocumentStar documentStar = new DocumentStar();
        documentStar.setEnvoiSolr(1);
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        documentStar.setDoc(doc);
        return documentStar;
    }
}
