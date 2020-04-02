package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "DOCUMENT")
@NoArgsConstructor
@Getter
@Setter
public class DocumentPortail implements Serializable, GenericEntity<Integer> {

    @Id
    @Column(name = "IDDOC")
    private Integer idDoc;

    @Column(name = "NNT")
    private String nnt;

    @ColumnTransformer(read = "NVL2(DOC, (DOC).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "DOC", columnDefinition = "XMLType")
    private String doc;

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

    public DocumentPortail(Integer idDoc, String doc, String texte, String codeEtab, Date dateInsertion, Date dateDiffusion,
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
