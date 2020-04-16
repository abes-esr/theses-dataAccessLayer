package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import com.sun.istack.NotNull;
import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "METADATA_TEF")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_METADATA_TEF")
public class MetadataTef implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "ID_METADATA_TEF")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_METADATA_TEF")
    private Integer idMetadataTef;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "OAIRECORD_ID")
    private OaiRecordTef oaiRecordId;
    @Lob
    @Column(name = "METADATA")
    private String metadata;

    public MetadataTef(OaiRecordTef oaiRecordId, String metadata) {
        this.oaiRecordId = oaiRecordId;
        this.metadata = metadata;
    }

    @Override
    public Integer getId() {
        return this.idMetadataTef;
    }
}
