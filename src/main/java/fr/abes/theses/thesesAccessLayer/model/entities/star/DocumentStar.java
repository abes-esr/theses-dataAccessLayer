package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.w3c.dom.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_DOC")
public class DocumentStar implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_DOC")
    @Column(name = "IDDOC")
    private Integer idDoc;

    @ColumnTransformer(read = "NVL2(DOC, (DOC).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "DOC")
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
