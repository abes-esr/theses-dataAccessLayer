package fr.abes.theses.thesesAccessLayer.configuration;

import org.hibernate.dialect.Oracle12cDialect;

public class OracleXmlDialect extends Oracle12cDialect {
    @Override
    public boolean useInputStreamToInsertBlob() {
        //This forces the use of CLOB binding when inserting
        return false;
    }
}
