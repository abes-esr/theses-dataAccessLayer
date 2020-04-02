package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter @Setter
public class DocumentStar implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Type(type = "fr.abes.theses.thesesAccessLayer.model.types.HibernateXmlType")
    @Column(name = "DOC")
    @Basic(fetch = FetchType.LAZY)
    private String doc;

    @Column(name = "TEXTE")
    private String texte;

    @Column(name = "CODEETAB")
    private String codeEtab;

    @Column(name = "ENVOISOLR")
    private Integer envoiSolr;

    public DocumentStar(Integer idDoc, String doc, String texte, String codeEtab, Integer envoiSolr) {
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
