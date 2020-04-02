package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.model.entities.star.NoticeBiblio;
import org.aspectj.weaver.ast.Not;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class INoticeiblioDaoTest {
    @Autowired
    private INoticeBiblioDao noticeBiblioDao;

    private NoticeBiblio noticeBiblio;

    @BeforeEach
    public void init() {
        noticeBiblio = getNoticeBiblio();
    }

    @Test
    public void testFindById() {
        NoticeBiblio noticeIn = noticeBiblioDao.save(noticeBiblio);
        NoticeBiblio noticeOut = noticeBiblioDao.findById(noticeIn.getId()).get();
        assertThat(noticeOut).isEqualTo(noticeIn);
    }

    @Test
    public void testFindAll() {
        NoticeBiblio noticeBiblio2 = getNoticeBiblio();
        noticeBiblio2.setId(2);
        NoticeBiblio notice1In = noticeBiblioDao.save(noticeBiblio);
        NoticeBiblio notice2In = noticeBiblioDao.save(noticeBiblio2);
        List<NoticeBiblio> listNotices = noticeBiblioDao.findAll();
        assertThat(listNotices.size()).isEqualTo(2);
        assertThat(listNotices.get(0)).isEqualTo(notice1In);
        assertThat(listNotices.get(1)).isEqualTo(notice2In);

    }

    @Test
    public void testDeleteById() {
        noticeBiblioDao.save(noticeBiblio);
        List<NoticeBiblio> noticeBiblios = noticeBiblioDao.findAll();
        noticeBiblioDao.deleteById(1);
        assertThat(noticeBiblioDao.findAll().size()).isEqualTo(0);
    }

    private NoticeBiblio getNoticeBiblio() {
        NoticeBiblio noticeBiblio = new NoticeBiblio();
        noticeBiblio.setCodeEtab("CAEN");
        noticeBiblio.setDateCreation(new Date());
        noticeBiblio.setId(1);
        noticeBiblio.setIddoc(1);
        return noticeBiblio;
    }
}
