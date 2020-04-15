package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ANRT_CORRESP")
@NoArgsConstructor
@Getter @Setter
@SequenceGenerator(name = "SEQ_ANRT")
public class AnrtCorresp implements Serializable, GenericEntity<Integer> {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ANRT")
    @Column(name = "ID_ANRT")
    private Integer idAnrt;
    @Column(name = "NNT")
    private String nnt;
    @Column(name = "URL")
    private String url;

    public AnrtCorresp(String nnt, String url) {
        this.nnt = nnt;
        this.url = url;
    }

    @Override
    public Integer getId() {
        return idAnrt;
    }
}
