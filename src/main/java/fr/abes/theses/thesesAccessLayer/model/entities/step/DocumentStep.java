package fr.abes.theses.thesesAccessLayer.model.entities.step;

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
@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class DocumentStep implements Serializable, GenericEntity<Integer> {

    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Type(type = "HibernateXMLType")
    @Column(name = "DOC", columnDefinition = "XMLType")
    private Document doc;

    @Column(name = "CODEETAB")
    private String codeEtab;


    public DocumentStep(Integer idDoc, Document doc, String codeEtab) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.codeEtab = codeEtab;
    }


    @Override
    public Integer getId() {
        return idDoc;
    }




}
