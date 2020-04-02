package fr.abes.theses.thesesAccessLayer.model.entities.star;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "VERROU")
@NoArgsConstructor
@Getter @Setter
public class Verrou implements Serializable {
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

    public Verrou(String nomTable, String idTable, String timestamp, String login, String sessionId) {
        this.nomTable = nomTable;
        this.idTable = idTable;
        this.login = login;
        this.timestamp = timestamp;
        this.sessionId = sessionId;
    }
}
