package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "COURRIEL")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_COURRIEL", sequenceName = "COURRIEL_SEQ", initialValue = 1, allocationSize = 1)
public class Courriel implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COURRIEL")
    @Column(name = "ID_COURRIEL")
    private Integer idCourriel;
    @Column(name = "DATE_ENVOI")
    @Temporal(TemporalType.DATE)
    private Calendar dateEnvoi;
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

    public Courriel(Integer idCourriel, Calendar dateEnvoi, String pageSource, String mailDemandeur, String mailDestinataire,
                    String objetMail, String messageMail, String ppnOrigine) {
        this.idCourriel = idCourriel;
        this.dateEnvoi = dateEnvoi;
        this.pageSource = pageSource;
        this.mailDemandeur = mailDemandeur;
        this.mailDestinataire = mailDestinataire;
        this.objetMail = objetMail;
        this.messageMail = messageMail;
        this.ppnOrigine = ppnOrigine;
    }

    @Override
    public Integer getId() {
        return this.idCourriel;
    }
}
