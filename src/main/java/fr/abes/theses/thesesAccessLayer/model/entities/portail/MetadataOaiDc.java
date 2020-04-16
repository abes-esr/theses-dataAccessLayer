package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import com.sun.istack.NotNull;
import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "METADATA_OAI_DC")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_METADATA_OAI_DC")
public class MetadataOaiDc implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "ID_METADATA_OAI_DC")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_METADATA_OAI_DC")
    private Integer idMetadataOaiDc;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "OAIRECORD_ID")
    private OaiRecordOaiDc oaiRecordId;
    @Lob
    @Column(name = "METADATA")
    private String metadata;

    public MetadataOaiDc(OaiRecordOaiDc oaiRecordId, String metadata) {
        this.oaiRecordId = oaiRecordId;
        this.metadata = metadata;
    }

    @Override
    public Integer getId() {
        return this.idMetadataOaiDc;
    }
}
