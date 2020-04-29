package fr.abes.theses.thesesAccessLayer.model.entities.star;

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
@Table(name = "SIM_THESES")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class SimTheses implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "CODE")
    String code;

    @Type(type = "HibernateXMLType")
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private Document fiche;

    public SimTheses(String code, Document fiche) {
        this.code = code;
        this.fiche = fiche;
    }

    @Override
    public String getId() {
        return this.code;
    }
}
