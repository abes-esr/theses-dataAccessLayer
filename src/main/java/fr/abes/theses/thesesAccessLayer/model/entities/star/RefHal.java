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


@Table(name = "REFHAL")
@NoArgsConstructor
@Getter @Setter
public class RefHal implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "IDLABO")
    Integer idLabo;
    @Column(name = "SNAMELABO")
    String snameLabo;
    @Column(name = "NAMELABO")
    String nameLabo;
    @Column(name = "URLLABO")
    String urlLabo;
    @Column(name = "PAYSLABO")
    String paysLabo;
    @Column(name = "STATUSLABO")
    String statusLabo;

    public RefHal(Integer idLabo, String snameLabo, String nameLabo, String urlLabo, String paysLabo, String statusLabo) {
        this.idLabo = idLabo;
        this.snameLabo = snameLabo;
        this.nameLabo = nameLabo;
        this.urlLabo = urlLabo;
        this.paysLabo = paysLabo;
        this.statusLabo = statusLabo;
    }

    @Override
    public Integer getId() {
        return idLabo;
    }
}
