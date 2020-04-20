package fr.abes.theses.thesesAccessLayer.model.entities.step;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "CompteStep")
@Table(name = "COMPTE")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_COMPTE", sequenceName = "SEQ_COMPTE", initialValue = 1, allocationSize = 1)
public class CompteStep implements Serializable, GenericEntity<Integer> {
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
    @Column(name = "CODEETAB")
    private String codeEtab;
    @Column(name = "DTCREA")
    @Temporal(TemporalType.DATE)
    private Calendar dtCrea;
    @Column(name = "DTMODIF")
    @Temporal(TemporalType.DATE)
    private Calendar dtModif;
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
