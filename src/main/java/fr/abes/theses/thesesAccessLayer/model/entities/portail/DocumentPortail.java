package fr.abes.theses.thesesAccessLayer.model.entities.portail;

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
import java.util.Date;

@Entity
@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter @Setter
@TypeDef(name = "HibernateXMLType", typeClass = HibernateXMLType.class)
public class DocumentPortail implements Serializable, GenericEntity<Integer> {

    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Column(name = "NNT")
    private String nnt;

    @Type(type = "HibernateXMLType")
    @Column(name = "DOC", columnDefinition = "XMLType")
    private Document doc;

    @Column(name = "TEXTE")
    private String texte;

    @Column(name = "CODEETAB")
    private String codeEtab;

    @Column(name = "DATEINSERTION")
    private Date dateInsertion;

    @Column(name = "DATEDIFFUSION")
    private Date dateDiffusion;

    @Column(name = "DROITS")
    private String droits;

    @Column(name = "NUMSUJET")
    private String numSujet;

    @Column(name = "ENVOISOLR")
    private boolean envoiSolr;

    public DocumentPortail(Integer idDoc, Document doc, String texte, String codeEtab, Date dateInsertion, Date dateDiffusion,
                           String droits, String numSujet, boolean envoiSolr) {
        this.idDoc = idDoc;
        this.doc = doc;
        this.texte = texte;
        this.codeEtab = codeEtab;
        this.dateInsertion = dateInsertion;
        this.dateDiffusion = dateDiffusion;
        this.droits = droits;
        this.numSujet = numSujet;
        this.envoiSolr = envoiSolr;
    }


    @Override
    public Integer getId() {
        return idDoc;
    }




}
