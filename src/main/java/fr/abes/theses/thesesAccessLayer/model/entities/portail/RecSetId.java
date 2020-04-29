package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
public class RecSetId implements Serializable {
    private Integer oaiRecordId;
    private Integer setId;

    public RecSetId(Integer oaiRecordId, Integer setId) {
        this.oaiRecordId = oaiRecordId;
        this.setId = setId;
    }
}
