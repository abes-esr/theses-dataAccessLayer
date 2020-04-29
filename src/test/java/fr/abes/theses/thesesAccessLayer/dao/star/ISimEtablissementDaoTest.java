package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.SimEtablissemnt;
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
public class ISimEtablissementDaoTest {
    private SimEtablissemnt etablissement;

    @Autowired
    private ISimEtablissementDao etablissementDao;

    @BeforeEach
    public void init() throws DocumentException {
        etablissement = getEtablissement();
    }

    @AfterEach
    public void end() {
        etablissementDao.delete(etablissement);
    }

    @Test
    public void testFindById() throws TransformerException {
        SimEtablissemnt etablissementIn = etablissementDao.save(etablissement);
        SimEtablissemnt etablissementout = etablissementDao.findById(etablissementIn.getId()).get();
        assertThat(etablissementout.getCode()).isEqualTo(etablissementIn.getCode());
        assertThat(HibernateXMLType.domToString(etablissementout.getFiche())).isEqualTo(HibernateXMLType.domToString(etablissementIn.getFiche()));
    }

    @Test
    public void testDeleteById() {
        SimEtablissemnt etablissementStarIn = etablissementDao.save(etablissement);
        etablissementDao.deleteById(etablissementStarIn.getId());
        assertThat(etablissementDao.findById(etablissementStarIn.getId())).isEmpty();
    }

    private SimEtablissemnt getEtablissement() throws DocumentException {
        SimEtablissemnt etablissement = new SimEtablissemnt();
        etablissement.setCode("TEST");
        String filePath = getClass().getClassLoader().getResource("etablissement.xml").getPath();
        File xmlfile = new File(filePath);
        SAXReader reader = new SAXReader();
        etablissement.setFiche(reader.read(xmlfile));
        return etablissement;
    }
}
