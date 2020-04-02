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

@Table(name = "METADATAFORMAT")
@NoArgsConstructor
@Getter @Setter
public class MetadataFormat implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "PREFIX_ID")
    private Integer prefixId;
    @Column(name = "METADATAPREFIX")
    private String metadataPrefix;
    @Column(name = "METASCHEMA")
    private String metaSchema;
    @Column(name = "METANAMESPACE")
    private String metaNamespace;
    @Column(name = "VISIBLE")
    private boolean visible;

    public MetadataFormat(Integer prefixId, String metadataPrefix, String metaSchema, String metaNamespace, boolean visible) {
        this.prefixId= prefixId;
        this.metadataPrefix = metadataPrefix;
        this.metaSchema = metaSchema;
        this.metaNamespace = metaNamespace;
        this.visible = visible;
    }

    @Override
    public Integer getId() {
        return this.prefixId;
    }
}
