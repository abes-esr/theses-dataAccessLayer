package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import fr.abes.theses.thesesAccessLayer.model.types.HibernateXMLType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.w3c.dom.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT", schema = "STAR")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_DOC", sequenceName = "SEQ_DOC", initialValue = 1, allocationSize = 1)
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class DocumentStar implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DOC")
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Type(type = "HibernateXMLType")
    @Column(name = "DOC")
    private Document doc;

    @Column(name = "TEXTE")
    private String texte;

    @Column(name = "CODEETAB")
    private String codeEtab;

    @Column(name = "ENVOISOLR")
    private Integer envoiSolr;

    public DocumentStar(Integer idDoc, Document doc, String texte, String codeEtab, Integer envoiSolr) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.texte = texte;
        this.codeEtab = codeEtab;
        this.envoiSolr = envoiSolr;
    }

    @Override
    public Integer getId() {
        return idDoc;
    }
}
