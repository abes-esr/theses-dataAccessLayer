package fr.abes.theses.thesesAccessLayer.model.entities.portail;

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
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MDP")
    private String mdp;
    @Column(name = "DNOM")
    private String dnom;
    @Column(name = "IDP")
    private String idp;
    @Column(name = "DTCREA")
    private Date dtCrea;
    @Column(name = "DTMODIF")
    private Date dtModif;
    @Column(name = "NUMSUJET")
    private String numSujet;
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "PPN")
    private String ppn;
    @Column(name = "SOURCE")
    private String source;

    @Override
    public Integer getId() {
        return this.idCompte;
    }
}
