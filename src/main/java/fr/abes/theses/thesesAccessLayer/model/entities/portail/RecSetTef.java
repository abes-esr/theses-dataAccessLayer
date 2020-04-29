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
@Table(name = "REC_SET_TEF")
@Getter @Setter
@IdClass(RecSetId.class)
@NoArgsConstructor
public class RecSetTef implements Serializable, GenericEntity<RecSetId> {
    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "OAIRECORD_ID")
    private OaiRecordTef oaiRecordId;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "SET_ID")
    private OaiSet setId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATEINSERTION")
    private Calendar dateInsertion;

    public RecSetTef(OaiRecordTef oaiRecordId, OaiSet setId, Calendar dateInsertion) {
        this.oaiRecordId = oaiRecordId;
        this.setId = setId;
        this.dateInsertion = dateInsertion;
    }

    @Override
    public RecSetId getId() {
        return new RecSetId(this.oaiRecordId.getId(), this.setId.getId());
    }
}
