package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.DocumentPortail;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
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
public class IDocumentPortailDaoTest {
    private DocumentPortail documentPortail;

    @Autowired
    private IDocumentPortailDao documentPortailDao;

    @BeforeEach
    public void init() throws DocumentException {
        documentPortail = getDocumentPortail();
    }

    @AfterEach
    public void end() {
        documentPortailDao.delete(documentPortail);
    }

    @Test
    public void testFindById() throws TransformerException {
        DocumentPortail documentIn = documentPortailDao.save(documentPortail);
        DocumentPortail documentOut = documentPortailDao.findById(documentIn.getId()).get();
        assertThat(documentOut.getCodeEtab()).isEqualTo(documentIn.getCodeEtab());
        assertThat(HibernateXMLType.domToString(documentOut.getDoc())).isEqualTo(HibernateXMLType.domToString(documentIn.getDoc()));
    }

    @Test
    public void testDeleteById() {
        DocumentPortail documentStepIn = documentPortailDao.save(documentPortail);
        documentPortailDao.deleteById(documentStepIn.getId());
        assertThat(documentPortailDao.findById(documentStepIn.getId())).isEmpty();
    }

    private DocumentPortail getDocumentPortail() throws DocumentException {
        DocumentPortail documentPortail = new DocumentPortail();
        documentPortail.setIdDoc(999999);
        documentPortail.setCodeEtab("TEST");
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File xmlFile = new File(filePath);
        SAXReader reader = new SAXReader();
        documentPortail.setDoc(reader.read(xmlFile));
        return documentPortail;
    }
}
