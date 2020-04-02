package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "OAIRECORD_OAI_DC")
@NoArgsConstructor
@Getter @Setter
public class OaiRecordOaiDc implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "OAIRECORD_ID")
    private Integer oaiRecordId;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEINSERTION")
    private Date dateInsertion;
    @Column(name = "OAIIDENTIFIER")
    private String oaiIdentifier;

    public OaiRecordOaiDc(Integer oaiRecordId, Date dateInsertion, String oaiIdentifier) {
        this.oaiRecordId = oaiRecordId;
        this.dateInsertion = dateInsertion;
        this.oaiIdentifier = oaiIdentifier;
    }

    @Override
    public Integer getId() {
        return this.oaiRecordId;
    }
}
