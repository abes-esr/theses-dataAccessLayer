package fr.abes.theses.thesesAccessLayer.model.entities.star;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "COMMENTAIRES")
@NoArgsConstructor
@Getter @Setter
public class Commentaires implements Serializable {
    @Column(name = "IDTHESE")
    private Integer idThese;
    @Column(name = "VALEUR")
    private String valeur;
    @Column(name = "OBJET")
    private String objet;
    @Column(name = "DATEC")
    private Integer datec;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "DISPLAYNAME")
    private String displayName;
}
