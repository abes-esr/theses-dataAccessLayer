package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.w3c.dom.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ETABLISSEMENT")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class EtablissementPortail implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "CODE")
    private String code;
    @Column(name = "IP")
    private String ip;

    @Type(type = "HibernateXMLType")
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private Document fiche;

    public EtablissementPortail(String code, String ip, Document fiche) {
        this.code = code;
        this.ip = ip;
        this.fiche = fiche;
    }

    @Override
    public String getId() {
        return this.code;
    }
}
