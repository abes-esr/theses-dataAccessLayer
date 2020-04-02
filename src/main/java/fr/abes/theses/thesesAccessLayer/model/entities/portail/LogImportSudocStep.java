package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "LOG_IMPORT_SUDOC_STEP")
@NoArgsConstructor
@Getter @Setter
public class LogImportSudocStep implements Serializable {
    @Column(name = "IDSTEP")
    private String idStep;
    @Column(name = "NOMAUTEUR")
    private String nomAuteur;
    @Column(name = "PRENOMAUTEUR")
    private String prenomAuteur;
    @Column(name = "CODETAB")
    private String codeEtab;
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "DTINSERT")
    private Date dtInsert;

    public LogImportSudocStep(String idStep, String nomAuteur, String prenomAuteur, String codeEtab, String nnt, Date dtInsert) {
        this.idStep = idStep;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.codeEtab = codeEtab;
        this.nnt = nnt;
        this.dtInsert = dtInsert;
    }
}
