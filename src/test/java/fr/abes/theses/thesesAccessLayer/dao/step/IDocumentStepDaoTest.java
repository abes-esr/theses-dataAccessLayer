package fr.abes.theses.thesesAccessLayer.dao.step;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.step.DocumentStep;
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
public class IDocumentStepDaoTest {
    private DocumentStep documentStep;

    @Autowired
    private IDocumentStepDao documentStepDao;

    @BeforeEach
    public void init() throws DocumentException {
        documentStep = getDocumentStep();
    }

    @AfterEach
    public void end() {
        documentStepDao.delete(documentStep);
    }

    @Test
    public void testfindById() throws TransformerException {
        DocumentStep documentIn = documentStepDao.save(documentStep);
        DocumentStep documentOut = documentStepDao.findById(documentIn.getId()).get();
        assertThat(documentOut.getCodeEtab()).isEqualTo(documentIn.getCodeEtab());
        assertThat(HibernateXMLType.domToString(documentOut.getDoc())).isEqualTo(HibernateXMLType.domToString(documentIn.getDoc()));
    }

    @Test
    public void testDeleteById() {
        DocumentStep documentStepIn = documentStepDao.save(documentStep);
        documentStepDao.deleteById(documentStepIn.getId());
        assertThat(documentStepDao.findById(documentStepIn.getId())).isEmpty();
    }

    private DocumentStep getDocumentStep() throws DocumentException {
        DocumentStep documentStep = new DocumentStep();
        documentStep.setIdDoc(999999);
        documentStep.setCodeEtab("TEST");
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File xmlfile = new File(filePath);
        SAXReader reader = new SAXReader();
        documentStep.setDoc(reader.read(xmlfile));
        return documentStep;
    }
}
