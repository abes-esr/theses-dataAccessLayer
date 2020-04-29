package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class CompteId implements Serializable {
    private Integer idCompte;
    private String email;

    public CompteId(Integer idCompte, String email) {
        this.email = email;
        this.idCompte = idCompte;
    }
}
