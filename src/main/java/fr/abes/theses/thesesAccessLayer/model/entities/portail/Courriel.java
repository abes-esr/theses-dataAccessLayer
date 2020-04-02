package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "COURRIEL")
@NoArgsConstructor
@Getter @Setter
public class Courriel implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "ID_COURRIEL")
    private Integer idCourriel;
    @Column(name = "DATE_ENVOI")
    private Date dateEnvoi;
    @Column(name = "PAGE_SOURCE")
    private String pageSource;
    @Column(name = "MAIL_DEMANDEUR")
    private String mailDemandeur;
    @Column(name = "MAIL_DESTINATAIRE")
    private String mailDestinataire;
    @Column(name = "OBJET_MAIL")
    private String objetMail;
    @Column(name = "MESSAGE_MAIL")
    private String messageMail;
    @Column(name = "PPN_ORIGINE")
    private String ppnOrigine;

    public Courriel(Integer idCourriel, Date dateEnvoi, String pageSource, String mailDemandeur, String mailDestinataire,
                    String objetMail, String messageMail, String ppnOrigine) {
        this.idCourriel = idCourriel;
        this.dateEnvoi = dateEnvoi;
        this.pageSource = pageSource;
        this.mailDemandeur = mailDemandeur;
        this.mailDemandeur = mailDemandeur;
        this.objetMail = objetMail;
        this.messageMail = messageMail;
        this.ppnOrigine = ppnOrigine;
    }

    @Override
    public Integer getId() {
        return this.idCourriel;
    }
}
