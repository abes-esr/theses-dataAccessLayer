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
@Table(name = "RESUMPTIONTOKEN")
@NoArgsConstructor
@Getter @Setter
public class ResumptionToken implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "RESUMPTIONTOKEN")
    private String resumptionToken;
    @Column(name = "VERB")
    private String verb;
    @Column(name = "RTCURSOR")
    private Integer rtCursor;
    @Column(name = "EXPIRATIONDATE")
    @Temporal(TemporalType.DATE)
    private Calendar expirationDate;
    @Column(name = "METADATAPREFIX")
    private String metadataPrefix;
    @Column(name = "FROMDATE")
    @Temporal(TemporalType.DATE)
    private Calendar fromDate;
    @Column(name = "UNTILDATE")
    @Temporal(TemporalType.DATE)
    private Calendar untilDate;
    @Column(name = "SET_ID")
    private Integer setId;
    @Column(name = "PREVIOUSRECORDID")
    private Integer previousRecordId;

    public ResumptionToken(String resumptionToken, String verb, Integer rtCursor, Calendar expirationDate, String metadataPrefix,
                           Calendar fromDate, Calendar untilDate, Integer setId, Integer previousRecordId) {
        this.resumptionToken = resumptionToken;
        this.verb = verb;
        this.rtCursor = rtCursor;
        this.expirationDate = expirationDate;
        this.metadataPrefix = metadataPrefix;
        this.fromDate = fromDate;
        this.untilDate = untilDate;
        this.setId = setId;
        this.previousRecordId = previousRecordId;
    }

    @Override
    public String getId() {
        return this.resumptionToken;
    }
}
