package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name = "REC_SET_OAI_DC")
@NoArgsConstructor
@IdClass(RecSetId.class)
@Getter @Setter
public class RecSetOaiDc implements Serializable, GenericEntity<RecSetId> {
    @Id
    @Column(name = "OAIRECORD_ID")
    private Integer oaiRecordId;

    @Id
    @Column(name = "SET_ID")
    private Integer setId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEINSERTION")
    private Date dateInsertion;

    public RecSetOaiDc(Integer oaiRecordId, Integer setId, Date dateInsertion) {
        this.oaiRecordId = oaiRecordId;
        this.setId = setId;
        this.dateInsertion = dateInsertion;
    }

    @Override
    public RecSetId getId() {
        return new RecSetId(this.oaiRecordId, this.setId);
    }
}