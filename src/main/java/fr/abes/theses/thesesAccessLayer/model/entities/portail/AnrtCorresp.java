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


@Table(name = "ANRT_CORRESP")
@NoArgsConstructor
@Getter @Setter
public class AnrtCorresp implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "URL")
    private String url;

    public AnrtCorresp(String nnt, String url) {
        this.nnt = nnt;
        this.url = url;
    }

    @Override
    public String getId() {
        return nnt;
    }
}
