package fr.abes.theses.thesesAccessLayer.model.entities.star;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "SIM_THESES")
@NoArgsConstructor
@Getter @Setter
public class SimTheses implements Serializable {
    @Column(name = "CODE")
    String code;

    @ColumnTransformer(read = "NVL2(FICHE, (FICHE).getClobVal(), NULL)", write = "NULLSAFE_XMLTYPE(?)")
    @Lob
    @Column(name = "FICHE", columnDefinition = "XMLType")
    private String fiche;

    public SimTheses(String code, String fiche) {
        this.code = code;
        this.fiche = fiche;
    }
}
