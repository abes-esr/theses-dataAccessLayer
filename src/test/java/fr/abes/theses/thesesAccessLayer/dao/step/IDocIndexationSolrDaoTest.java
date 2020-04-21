package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.step.DocIndexationSolr;
import fr.abes.theses.thesesAccessLayer.model.entities.step.DocumentStep;
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
public class IDocIndexationSolrDaoTest {
    private DocIndexationSolr docIndexationSolr;

    @Autowired
    private IDocIndexationSolrDao docIndexationSolrDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException, JDOMException {
        docIndexationSolr = getIndexationSolr();
    }

    @AfterEach
    public void end() {
        docIndexationSolrDao.delete(docIndexationSolr);
    }

    @Test
    public void testFindById() throws TransformerException {
        DocIndexationSolr documentIn = docIndexationSolrDao.save(docIndexationSolr);
        DocIndexationSolr documentOut = docIndexationSolrDao.findById(documentIn.getId()).get();
        assertThat(documentOut.getCodeEtab()).isEqualTo(documentIn.getCodeEtab());
        assertThat(HibernateXMLType.domToString(documentOut.getDoc())).isEqualTo(HibernateXMLType.domToString(documentIn.getDoc()));
    }

    @Test
    public void testDeleteById() {
        DocIndexationSolr documentIn = docIndexationSolrDao.save(docIndexationSolr);
        docIndexationSolrDao.deleteById(documentIn.getId());
        assertThat(docIndexationSolrDao.findById(documentIn.getId())).isEmpty();
    }

    private DocIndexationSolr getIndexationSolr() throws IOException, SAXException, ParserConfigurationException, JDOMException {
        DocIndexationSolr docIndexationSolr = new DocIndexationSolr();
        docIndexationSolr.setIdDoc(999999);
        docIndexationSolr.setCodeEtab("TEST");
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        docIndexationSolr.setDoc(doc);
        return docIndexationSolr;
    }

}
