package fr.abes.theses.thesesAccessLayer.model.entities.star;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "DOMAINEHAL")
@NoArgsConstructor
@Getter @Setter
public class DomaineHal implements Serializable {
    @Column(name = "IDDOMAINE")
    private String idDomaine;
    @Column(name = "CODE")
    private String code;
    @Column(name = "HAVENEXT")
    private String haveNext;
    @Column(name = "LEVELDOMAINE")
    private String levelDomaine;
    @Column(name = "PARENTID")
    private String parentId;

    public DomaineHal(String idDomaine, String code, String haveNext, String levelDomaine, String parentId) {
        this.idDomaine = idDomaine;
        this.code = code;
        this.haveNext = haveNext;
        this.levelDomaine = levelDomaine;
        this.parentId = parentId;
    }
}
