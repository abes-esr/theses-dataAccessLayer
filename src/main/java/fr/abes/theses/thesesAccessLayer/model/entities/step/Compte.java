package fr.abes.theses.thesesAccessLayer.model.entities.step;

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
    @Column(name = "CODEETAB")
    private String codeEtab;
    @Column(name = "DTCREA")
    private Date dtCrea;
    @Column(name = "DTMODIF")
    private Date dtModif;
    @Column(name = "ESTACTIF")
    private boolean estActif;
    @Column(name = "ROLE")
    private String role;
    @Column(name = "PSEUDO")
    private String pseudo;

    @Override
    public Integer getId() {
        return this.idCompte;
    }
}
