package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.ZonePrioritaire;
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
public class IZonePrioritaireDaoTest {
    public ZonePrioritaire zonePrioritaire;

    @Autowired
    private IZonePrioritaireDao zonePrioritaireDao;

    @BeforeEach
    public void init() {
        zonePrioritaire = getZonePrioritaire();
    }

    @AfterEach
    public void end(){
        zonePrioritaireDao.delete(zonePrioritaire);
    }

    @Test
    public void testFindCompte() {
        ZonePrioritaire zonePrioritaireIn = zonePrioritaireDao.save(zonePrioritaire);
        ZonePrioritaire zonePrioritaireOut = zonePrioritaireDao.findById(zonePrioritaireIn.getId()).get();
        assertThat(zonePrioritaireOut.getId()).isEqualTo(zonePrioritaireIn.getId());
        assertThat(zonePrioritaireOut.getLabelZone()).isEqualTo(zonePrioritaireIn.getLabelZone());
    }

    @Test
    public void testSaveCompte() {
        ZonePrioritaire ZonePrioritaireIn = zonePrioritaireDao.save(zonePrioritaire);
        assertThat(ZonePrioritaireIn.getId()).isEqualTo(zonePrioritaire.getId());
        assertThat(ZonePrioritaireIn.getLabelZone()).isEqualTo(zonePrioritaire.getLabelZone());
    }

    @Test
    public void deleteById() {
        ZonePrioritaire zonePrioritaireIn = zonePrioritaireDao.save(zonePrioritaire);
        zonePrioritaireDao.deleteById(zonePrioritaireIn.getId());
        assertThat(zonePrioritaireDao.findById(zonePrioritaireIn.getId())).isEmpty();
    }

    private ZonePrioritaire getZonePrioritaire() {
        ZonePrioritaire zonePrioritaire = new ZonePrioritaire();
        zonePrioritaire.setId(999);
        zonePrioritaire.setLabelZone("TEST");
        return zonePrioritaire;
    }
}
