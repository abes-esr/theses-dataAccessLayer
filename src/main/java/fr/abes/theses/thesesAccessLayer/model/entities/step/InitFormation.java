package fr.abes.theses.thesesAccessLayer.model.entities.step;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Clob;


@Table(name = "INIT_FORMATION")
@NoArgsConstructor
@Getter @Setter
public class InitFormation implements Serializable {
    @Column(name = "IDDOC")
    private Integer idDoc;

    @ColumnTransformer(read = "NVL2(DOC, (DOC).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "DOC", columnDefinition = "XMLType")
    private String doc;

    @Column(name = "TEXTE")
    @Lob
    private Clob texte;

    @Column(name = "CODEETAB")
    private String codeEtab;
}
