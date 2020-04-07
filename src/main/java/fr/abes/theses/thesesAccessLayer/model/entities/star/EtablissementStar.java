package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ETABLISSEMENT")
@NoArgsConstructor
@Getter @Setter
public class EtablissementStar implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "CODE")
    private String code;

    @ColumnTransformer(read = "NVL2(FICHE, to_clob(FICHE), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private String fiche;

    public EtablissementStar(String code, String fiche) {
        this.code = code;
        this.fiche = fiche;
    }

    @Override
    public String getId() {
        return this.code;
    }
}
