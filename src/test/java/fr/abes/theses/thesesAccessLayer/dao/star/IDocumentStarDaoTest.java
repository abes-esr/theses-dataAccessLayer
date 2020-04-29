package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
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

import javax.xml.transform.TransformerException;
import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IDocumentStarDaoTest {
    private DocumentStar documentStar;

    @Autowired
    private IDocumentStarDao documentStarDao;

    @BeforeEach
    public void init() throws DocumentException {
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

    private DocumentStar getDocumentStar() throws DocumentException {
        DocumentStar documentStar = new DocumentStar();
        documentStar.setEnvoiSolr(1);
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        File xmlfile = new File(filePath);
        SAXReader reader = new SAXReader();
        documentStar.setDoc(reader.read(xmlfile));
        return documentStar;
    }
}
