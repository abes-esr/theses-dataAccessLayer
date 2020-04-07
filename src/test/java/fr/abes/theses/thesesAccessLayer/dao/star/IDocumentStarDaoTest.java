package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import org.dom4j.Document;
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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IDocumentStarDaoTest {
    public DocumentStar document;

    @Autowired
    private IDocumentStarDao documentDao;

    @BeforeEach
    public void init() throws DocumentException {
        document = getDocument();
    }

    @AfterEach
    public void end() {
        documentDao.delete(document);
    }

    @Test
    public void testFindDocument() {
        DocumentStar docInDb = documentDao.save(document);
        DocumentStar docOutDb = documentDao.findById(docInDb.getIdDoc()).get();
        assertThat(docOutDb.getId()).isEqualTo(docInDb.getId());
        assertThat(docOutDb.getDoc()).isEqualTo(docInDb.getDoc());
    }

    @Test
    public void testDeleteById() {
        DocumentStar documentOut = documentDao.save(document);
        documentDao.deleteById(documentOut.getId());
        assertThat(documentDao.findById(documentOut.getId())).isEmpty();
    }

    private DocumentStar getDocument() throws DocumentException {
        DocumentStar document = new DocumentStar();
        document.setCodeEtab("CAEN");
        document.setEnvoiSolr(0);
        document.setTexte("test");
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        SAXReader xmlReader = new SAXReader();
        Document xml = xmlReader.read(filePath);
        document.setDoc(xml.toString());

        return document;
    }
}
