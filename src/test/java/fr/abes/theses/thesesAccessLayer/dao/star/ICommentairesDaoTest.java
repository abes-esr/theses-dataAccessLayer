package fr.abes.theses.thesesAccessLayer.dao.star;

import fr.abes.theses.thesesAccessLayer.ThesesAccessLayerApplication;
import fr.abes.theses.thesesAccessLayer.model.entities.star.Commentaires;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableTransactionManagement
public class ICommentairesDaoTest {
    public Commentaires commentaire;

    @Autowired
    private ICommentairesDao commentairesDao;

    @BeforeEach
    public void init() {
        commentaire = getCommentaire();
    }

    @AfterEach
    public void end(){
        commentairesDao.delete(commentaire);
    }

    @Test
    public void testfindById() {
        Commentaires commentaireIn = commentairesDao.save(commentaire);
        Commentaires commentaireOut = commentairesDao.findById(commentaireIn.getId()).get();
        assertThat(commentaireOut.getId()).isEqualTo(commentaireIn.getId());
        assertThat(commentaireOut.getDisplayName()).isEqualTo(commentaireIn.getDisplayName());
    }

    @Test
    public void testSave() {
        Commentaires commentaireIn = commentairesDao.save(commentaire);
        assertThat(commentaireIn.getId()).isEqualTo(commentaire.getId());
        assertThat(commentaireIn.getDisplayName()).isEqualTo(commentaire.getDisplayName());
    }

    @Test
    public void testDeleteById() {
        Commentaires commentaireIn = commentairesDao.save(commentaire);
        commentairesDao.deleteById(commentaireIn.getId());
        assertThat(commentairesDao.findById(commentaireIn.getId())).isEmpty();
    }

    private Commentaires getCommentaire() {
        Commentaires commentaire = new Commentaires();
        commentaire.setDisplayName("TEST");
        return commentaire;
    }
}
