package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import com.sun.istack.NotNull;
import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "METADATA_MARC")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_METADATA_MARC", sequenceName = "SEQ_METADATA_MARC", allocationSize = 1, initialValue = 1)
public class MetadataMarc implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "ID_METADATA_MARC")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_METADATA_MARC")
    private Integer idMetadataMarc;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "OAIRECORD_ID")
    private OaiRecordMarc oaiRecordId;
    @Lob
    @Column(name = "METADATA")
    private String metadata;

    public MetadataMarc(OaiRecordMarc oaiRecordId, String metadata) {
        this.oaiRecordId = oaiRecordId;
        this.metadata = metadata;
    }

    @Override
    public Integer getId() {
        return this.idMetadataMarc;
    }
}
