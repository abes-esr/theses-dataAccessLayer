package fr.abes.theses.thesesAccessLayer.model.entities.step;

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
import java.sql.Clob;


@Entity
@Table(name = "INIT_FORMATION")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class InitFormationStep implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Type(type = "HibernateXMLType")
    @Column(name = "DOC", columnDefinition = "XMLType")
    private Document doc;

    @Column(name = "TEXTE")
    @Lob
    private Clob texte;

    @Column(name = "CODEETAB")
    private String codeEtab;

    public InitFormationStep(Integer idDoc, Document doc, Clob texte, String codeEtab) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.texte = texte;
        this.codeEtab = codeEtab;
    }

    @Override
    public Integer getId() {
        return this.idDoc;
    }
}
