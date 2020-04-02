package fr.abes.theses.thesesAccessLayer.model.entities.portail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Table(name = "IDENTIFICATION")
@NoArgsConstructor
@Getter @Setter
public class Identification implements Serializable {
    @Column(name = "REPOSITORYNAME")
    private String repositoryName;
    @Column(name = "BASEURL")
    private String baseUrl;
    @Column(name = "PROTOCOLVERSION")
    private String protocolVersion;
    @Column(name = "EARLIESTDATESTAMP")
    private Date earliestDateStamp;
    @Column(name = "DELETEDRECORD")
    private String deletedRecord;
    @Column(name = "GRANULARITY")
    private String granularity;
    @Column(name = "ADMINEMAIL")
    private String adminEmail;
    @Column(name = "COMPRESSION")
    private String compression;
    @Column(name = "DESCRIPTION")
    private String description;

    public Identification(String repositoryName, String baseUrl, String protocolVersion, Date earliestDateStamp, String deletedRecord,
                          String granularity, String adminEmail, String compression, String description) {
        this.repositoryName = repositoryName;
        this.baseUrl = baseUrl;
        this.protocolVersion = protocolVersion;
        this.earliestDateStamp = earliestDateStamp;
        this.deletedRecord = deletedRecord;
        this.granularity = granularity;
        this.adminEmail = adminEmail;
        this.compression = compression;
        this.description = description;
    }

}
