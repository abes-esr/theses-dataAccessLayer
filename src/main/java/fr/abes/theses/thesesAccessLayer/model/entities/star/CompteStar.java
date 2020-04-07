package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


@Entity(name = "CompteStar")
@Table(name = "COMPTE")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_COMPTE")
public class CompteStar implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMPTE")
    @Column(name = "IDCOMPTE")
    private Integer idCompte;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "MDP")
    private String mdp;
    @Column(name = "IDDOC")
    private Integer idDoc;
    @Column(name = "MELINSTI")
    private String melInsti;
    @Column(name = "MELPERSO")
    private String melPerso;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "CODEPOSTAL")
    private String codePostal;
    @Column(name = "VILLE")
    private String ville;
    @Column(name = "PAYS")
    private String pays;
    @Column(name = "SEXE")
    private String sexe;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "DISPLAYNAME")
    private String displayName;
    @Column(name = "NUMIDENT")
    private String numIdent;
    @Column(name = "CODEETAB")
    private String codeEtab;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "TEL")
    private String tel;
    @Column(name = "ESTACTIF")
    private boolean estActif;
    @Column(name = "DTCREA")
    @Temporal(TemporalType.DATE)
    private Calendar dtCrea;
    @Column(name = "DTMODIF")
    @Temporal(TemporalType.DATE)
    private Calendar dtModif;

    @Override
    public Integer getId() {
        return this.idCompte;
    }
}
