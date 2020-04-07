package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.InitFormationStep;
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
public class IInitFormationStarDaoTest {
    private InitFormationStep initFormation;

    @Autowired
    private IInitFormationStarDao initFormationDao;

    @BeforeEach
    public void init() throws ParserConfigurationException, SAXException, IOException {
        initFormation = getInitFormation();
    }

    @AfterEach
    public void end() {
        initFormationDao.delete(initFormation);
    }

    @Test
    public void findEtablissementTest() {
        InitFormationStep initFormationIn = initFormationDao.save(initFormation);
        InitFormationStep initFormationOut = initFormationDao.findById(initFormationIn.getId()).get();
        assertThat(initFormationOut.getCodeEtab()).isEqualTo(initFormationIn.getCodeEtab());
        assertThat(initFormationOut.getDoc()).isEqualTo(initFormationIn.getDoc());
    }

    private InitFormationStep getInitFormation() throws IOException, SAXException, ParserConfigurationException {
        InitFormationStep initFormation = new InitFormationStep();
        initFormation.setCodeEtab("TEST");
        File xml = new File(getClass().getClassLoader().getResource("initFormation.xml").getPath());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(xml) ;
        initFormation.setDoc(doc.toString());
        return initFormation;
    }
}
