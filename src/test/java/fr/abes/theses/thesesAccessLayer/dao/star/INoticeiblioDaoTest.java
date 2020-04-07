package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class INoticeiblioDaoTest {
    @Autowired
    private INoticeBiblioDao noticeBiblioDao;

    private NoticeBiblio noticeBiblio;

    @BeforeEach
    public void init() {
        noticeBiblio = getNoticeBiblio();
    }

    @AfterEach
    public void end() { noticeBiblioDao.delete(noticeBiblio);}
    @Test
    public void testFindById() {
        NoticeBiblio noticeIn = noticeBiblioDao.save(noticeBiblio);
        NoticeBiblio noticeOut = noticeBiblioDao.findById(noticeIn.getId()).get();
        assertThat(noticeOut.getId()).isEqualTo(noticeIn.getId());
    }

    @Test
    public void testDeleteById() {
        NoticeBiblio noticeBiblioOut = noticeBiblioDao.save(noticeBiblio);
        noticeBiblioDao.deleteById(noticeBiblioOut.getId());
        assertThat(noticeBiblioDao.findById(noticeBiblioOut.getId())).isEmpty();
    }

    private NoticeBiblio getNoticeBiblio() {
        NoticeBiblio noticeBiblio = new NoticeBiblio();
        noticeBiblio.setCodeEtab("CAEN");
        noticeBiblio.setDateCreation(new Date());
        noticeBiblio.setId(1);
        noticeBiblio.setIddoc(1);
        noticeBiblio.setDone(0);
        noticeBiblio.setIddoc(1);
        return noticeBiblio;
    }
}
