package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.DocumentStar;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class IDocumentDaoTest {
    public DocumentStar document;

    @Autowired
    private IDocumentDao documentDao;

    @BeforeEach
    public void init() throws DocumentException {
            document = getDocument();
    }

    @Test
    public void testFindDocument() {
        DocumentStar docInDb = documentDao.save(document);
        DocumentStar docFromDb = documentDao.findById(docInDb.getIdDoc()).get();
        assertThat(docFromDb).isEqualTo(docInDb);
    }

    @Test
    public void testSaveDocument() {
        DocumentStar docInDb = documentDao.save(document);
        assertThat(docInDb.getCodeEtab()).isEqualTo("CAEN");
    }

    @Test
    public void testFindAllDocument() throws DocumentException {
        DocumentStar document2In = getDocument();
        document2In.setIdDoc(2);
        DocumentStar document1Out = documentDao.save(document);
        DocumentStar document2Out = documentDao.save(document2In);

        List<DocumentStar> listDocument = documentDao.findAll();
        assertThat(listDocument.size()).isEqualTo(2);
        assertThat(listDocument.get(0)).isEqualTo(document1Out);
        assertThat(listDocument.get(1)).isEqualTo(document2Out);
    }

    private DocumentStar getDocument() throws DocumentException {
        DocumentStar document = new DocumentStar();
        document.setCodeEtab("CAEN");
        document.setEnvoiSolr(0);
        document.setIdDoc(1);
        document.setTexte("test");
        String filePath = getClass().getClassLoader().getResource("tef.xml").getPath();
        SAXReader xmlReader = new SAXReader();
        Document xml = xmlReader.read(filePath);
        document.setDoc(xml.toString());

        return document;
    }
}
