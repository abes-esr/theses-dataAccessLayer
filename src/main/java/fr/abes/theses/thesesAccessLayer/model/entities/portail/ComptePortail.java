package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "COMPTE")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_COMPTE", sequenceName = "SEQ_COMPTE", initialValue = 1, allocationSize = 1)
@IdClass(CompteId.class)
public class ComptePortail implements Serializable, GenericEntity<CompteId> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_COMPTE")
    @Column(name = "IDCOMPTE")
    private Integer idCompte;
    @Id
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MDP")
    private String mdp;
    @Column(name = "DNOM")
    private String dnom;
    @Column(name = "IDP")
    private String idp;
    @Column(name = "DTCREA")
    @Temporal(TemporalType.DATE)
    private Calendar dtCrea;
    @Column(name = "DTMODIF")
    @Temporal(TemporalType.DATE)
    private Calendar dtModif;
    @Column(name = "NUMSUJET")
    private String numSujet;
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "PPN")
    private String ppn;
    @Column(name = "SOURCE")
    private String source;

    @Override
    public CompteId getId() {
        return new CompteId(this.idCompte, this.email);
    }
}

