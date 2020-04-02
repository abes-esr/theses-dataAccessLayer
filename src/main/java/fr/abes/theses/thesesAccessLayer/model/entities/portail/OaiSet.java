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

@Table(name = "OAISET")
@NoArgsConstructor
@Getter @Setter
public class OaiSet implements Serializable, GenericEntity<Integer> {
    @Id
    @Column(name = "SET_ID")
    private Integer setId;
    @Column(name = "SETSPEC")
    private String setSpec;
    @Column(name = "SETNAME")
    private String setName;
    @Column(name = "SETDESCRIPTION")
    private String setDescription;

    public OaiSet(Integer setId, String setSpec, String setName, String setDescription) {
        this.setId = setId;
        this.setSpec = setSpec;
        this.setName = setName;
        this.setDescription = setDescription;
    }

    @Override
    public Integer getId() {
        return this.setId;
    }
}
