package fr.abes.theses.thesesAccessLayer.model.entities.star;

import fr.abes.theses.thesesAccessLayer.model.entities.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LDAP_USER")
@NoArgsConstructor
@Setter @Getter
public class LdapUser implements Serializable, GenericEntity<String> {
    @Id
    @Column(name = "DN")
    String dn;
    @Column(name = "OBJECTCLASS")
    String objectClass;
    @Column(name = "OU")
    String ou;
    @Column(name = "NAME")
    String name;
    @Column(name = "WHENCHANGED")
    String whenChanged;
    @Column(name = "WHENCREATED")
    String whenCreated;
    @Column(name = "MEMBEROF")
    String memberOf;
    @Column(name = "CN")
    String cn;
    @Column(name = "DISPLAYNAME")
    String displayName;
    @Column(name = "DIVISION")
    String division;
    @Column(name = "EMPLOYEETYPE")
    String employeeType;
    @Column(name = "SAMACCOUNTNAME")
    String samAccountName;
    @Column(name = "CODEWKF")
    String codeWkf;
    @Column(name = "EMPLOYEEID")
    String employeeId;
    @Column(name = "GIVENNAME")
    String givenName;
    @Column(name = "SN")
    String sn;
    @Column(name = "BIRTHDAY")
    String birthday;
    @Column(name = "PATRONYMICNAME")
    String patronymicName;
    @Column(name = "MAIL")
    String mail;
    @Column(name = "L")
    String l;
    @Column(name = "POSTALADDRESS")
    String postalAddress;
    @Column(name = "POSTALCODE")
    String postalCode;
    @Column(name = "STREET")
    String street;
    @Column(name = "VISIBLEPROFIL")
    String visibleProfil;
    @Column(name = "GENDER")
    String gender;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "ROLE")
    String role;

    @Override
    public String getId() {
        return dn;
    }
}
