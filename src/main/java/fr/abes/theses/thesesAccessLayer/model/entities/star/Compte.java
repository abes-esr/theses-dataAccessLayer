package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "COMPTE")
@NoArgsConstructor
@Getter @Setter
public class Compte implements Serializable, GenericEntity<Integer> {
    @Id
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
    private Date dtCrea;
    @Column(name = "DTMODIF")
    private Date dtModif;

    @Override
    public Integer getId() {
        return this.idCompte;
    }
}
