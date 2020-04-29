package fr.abes.theses.thesesAccessLayer.dao.portail;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.portail.AnrtCorresp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ThesesAccessLayerApplication.class)
@EnableTransactionManagement
public class IAnrtCorrespDaoTest {
    public AnrtCorresp anrtCorresp;

    @Autowired
    private IAnrtCorrespDao anrtCorrespDao;

    @BeforeEach
    public void init() {
        anrtCorresp = getAnrtCorresp();
    }

    @AfterEach
    public void end(){
        anrtCorrespDao.delete(anrtCorresp);
    }

    @Test
    @Transactional
    public void testSave() {
        AnrtCorresp anrt = anrtCorrespDao.save(anrtCorresp);
        assertThat(anrt.getId()).isEqualTo(anrtCorresp.getId());
        assertThat(anrt.getNnt()).isEqualTo(anrtCorresp.getNnt());
        assertThat(anrt.getUrl()).isEqualTo(anrtCorresp.getUrl());
    }

    @Test
    @Transactional
    public void testDeleteById() {
        AnrtCorresp anrt = anrtCorrespDao.saveAndFlush(anrtCorresp);
        anrtCorrespDao.deleteById(anrt.getId());
        assertThat(anrtCorrespDao.findById(anrt.getId())).isEmpty();
    }


    @Test
    @Transactional
    public void testFindById() {
        AnrtCorresp anrtIn = anrtCorrespDao.save(anrtCorresp);
        AnrtCorresp anrtOut = anrtCorrespDao.findById(anrtIn.getId()).get();
        assertThat(anrtOut.getId()).isEqualTo(anrtIn.getId());
    }

    private AnrtCorresp getAnrtCorresp() {
        AnrtCorresp anrt = new AnrtCorresp();
        anrt.setNnt("test");
        anrt.setUrl("test");
        return anrt;
    }
}
