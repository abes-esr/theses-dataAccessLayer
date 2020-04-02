package fr.abes.theses.thesesAccessLayer.configuration;

import oracle.xdb.XMLType;
import org.hibernate.dialect.Oracle12cDialect;

public class OracleXmlDialect extends Oracle12cDialect {
    public OracleXmlDialect() {
        super();
        registerHibernateType(XMLType._SQL_TYPECODE, "XMLTYPE");
        registerColumnType(XMLType._SQL_TYPECODE, "XMLTYPE");
    }
}
