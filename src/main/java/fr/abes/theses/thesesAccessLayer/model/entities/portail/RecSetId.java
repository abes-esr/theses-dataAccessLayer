package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import java.io.Serializable;

public class RecSetId implements Serializable {
    private Integer oaiRecordId;
    private Integer setId;

    public RecSetId(Integer oaiRecordId, Integer setId) {
        this.oaiRecordId = oaiRecordId;
        this.setId = setId;
    }
}
