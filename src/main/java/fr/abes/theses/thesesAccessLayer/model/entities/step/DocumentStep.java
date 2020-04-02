package fr.abes.theses.thesesAccessLayer.model.entities.step;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter
@Setter
public class DocumentStep implements Serializable, GenericEntity<Integer> {

    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @ColumnTransformer(read = "NVL2(DOC, (DOC).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "DOC", columnDefinition = "XMLType")
    private String doc;

    @Column(name = "CODEETAB")
    private String codeEtab;


    public DocumentStep(Integer idDoc, String doc, String codeEtab) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.codeEtab = codeEtab;
    }


    @Override
    public Integer getId() {
        return idDoc;
    }




}
