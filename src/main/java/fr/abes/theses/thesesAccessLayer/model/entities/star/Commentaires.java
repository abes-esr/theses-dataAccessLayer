package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COMMENTAIRES")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_COMMENTAIRES", sequenceName = "SEQ_COMMENTAIRES", initialValue = 1, allocationSize = 1)
public class Commentaires implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMMENTAIRES")
    @Column(name = "IDCOMMENTAIRE")
    private Integer idCommentaire;
    @Column(name = "IDTHESE")
    private Integer idThese;
    @Column(name = "VALEUR")
    private String valeur;
    @Column(name = "OBJET")
    private String objet;
    @Column(name = "DATEC")
    private Integer datec;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "DISPLAYNAME")
    private String displayName;

    @Override
    public Integer getId() {
        return idCommentaire;
    }
}
