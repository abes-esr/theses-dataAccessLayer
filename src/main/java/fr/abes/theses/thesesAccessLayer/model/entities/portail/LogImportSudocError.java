package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "LOG_IMPORT_SUDOC_ERROR")
@NoArgsConstructor
@Getter @Setter
public class LogImportSudocError implements Serializable {
    @Column(name = "PPN")
    private String ppn;
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "DTINSERT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtInsert;

    public LogImportSudocError(String ppn, String nnt, Date dtInsert) {
        this.ppn = ppn;
        this.nnt = nnt;
        this.dtInsert = dtInsert;
    }
}
