package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Clob;

@Entity
@Table(name = "INIT_FORMATION")
@NoArgsConstructor
@Getter @Setter
public class InitFormationStep implements Serializable, GenericEntity<Integer> {
    @Id
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

    @Override
    public Integer getId() {
        return idDoc;
    }
}
