package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "VERROU")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_VERROU")
public class VerrouStar implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_VERROU")
    @Column(name = "IDVERROU")
    Integer idVerrou;
    @Column(name = "NOMTABLE")
    String nomTable;
    @Column(name = "IDTABLE")
    String idTable;
    @Column(name = "TIMESTAMP")
    String timestamp;
    @Column(name = "LOGIN")
    String login;
    @Column(name = "SESSIONID")
    String sessionId;

    public VerrouStar(String nomTable, String idTable, String timestamp, String login, String sessionId) {
        this.nomTable = nomTable;
        this.idTable = idTable;
        this.login = login;
        this.timestamp = timestamp;
        this.sessionId = sessionId;
    }

    @Override
    public Integer getId() {
        return idVerrou;
    }
}
