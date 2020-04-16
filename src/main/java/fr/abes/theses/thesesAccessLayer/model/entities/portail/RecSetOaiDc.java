package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import com.sun.istack.NotNull;
import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "REC_SET_OAI_DC")
@NoArgsConstructor
@IdClass(RecSetId.class)
@Getter @Setter
public class RecSetOaiDc implements Serializable, GenericEntity<RecSetId> {
    @Id
    @ManyToOne
    @JoinColumn(name = "OAIRECORD_ID")
    @NotNull
    private OaiRecordOaiDc oaiRecordId;

    @Id
    @ManyToOne
    @JoinColumn(name = "SET_ID")
    @NotNull
    private OaiSet setId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEINSERTION")
    private Calendar dateInsertion;

    public RecSetOaiDc(OaiRecordOaiDc oaiRecordId, OaiSet setId, Calendar dateInsertion) {
        this.oaiRecordId = oaiRecordId;
        this.setId = setId;
        this.dateInsertion = dateInsertion;
    }

    @Override
    public RecSetId getId() {
        return new RecSetId(this.oaiRecordId.getId(), this.setId.getId());
    }
}
