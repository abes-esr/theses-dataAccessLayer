package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "ETABLISSEMENT")
@NoArgsConstructor
@Getter @Setter
public class EtablissementPortail implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "IP")
    private String ip;
    @ColumnTransformer(read = "NVL2(FICHE, (FICHE).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private String fiche;

    public EtablissementPortail(String code, String ip, String fiche) {
        this.code = code;
        this.ip = ip;
        this.fiche = fiche;
    }

    @Override
    public String getId() {
        return this.code;
    }
}
