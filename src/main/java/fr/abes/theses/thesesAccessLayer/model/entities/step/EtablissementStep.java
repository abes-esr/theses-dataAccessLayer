package fr.abes.theses.thesesAccessLayer.model.entities.step;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dom4j.Document;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ETABLISSEMENT")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class EtablissementStep implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "CODE")
    private String code;

    @Type(type = "HibernateXMLType")
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private Document fiche;

    public EtablissementStep(String code, Document fiche) {
        this.code = code;
        this.fiche = fiche;
    }

    @Override
    public String getId() {
        return this.code;
    }
}
