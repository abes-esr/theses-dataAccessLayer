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


@Entity
@Table(name = "DOMAINEHAL")
@NoArgsConstructor
@Getter @Setter
public class DomaineHal implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "IDDOMAINE")
    private Integer idDomaine;
    @Column(name = "CODE")
    private String code;
    @Column(name = "LABEL")
    private String label;
    @Column(name = "HAVENEXT")
    private boolean haveNext;
    @Column(name = "LEVELDOMAINE")
    private String levelDomaine;
    @Column(name = "PARENTID")
    private Integer parentId;

    public DomaineHal(Integer idDomaine, String code, String label, boolean haveNext, String levelDomaine, Integer parentId) {
        this.idDomaine = idDomaine;
        this.code = code;
        this.label = label;
        this.haveNext = haveNext;
        this.levelDomaine = levelDomaine;
        this.parentId = parentId;
    }

    @Override
    public Integer getId() {
        return this.idDomaine;
    }
}
