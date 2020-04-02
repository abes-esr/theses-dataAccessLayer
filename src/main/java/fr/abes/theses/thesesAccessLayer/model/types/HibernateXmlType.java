package fr.abes.theses.thesesAccessLayer.model.types;

import oracle.jdbc.driver.OracleConnection;
import oracle.sql.CLOB;
import oracle.xdb.XMLType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.w3c.dom.Document;

import java.io.Serializable;
import java.sql.*;

public class HibernateXmlType implements UserType, Serializable {
    @Override
    public int[] sqlTypes() {
        return new int[] { oracle.xdb.XMLType._SQL_TYPECODE};
    }

    @Override
    public Class returnedClass() {
        return Document.class;
    }

    @Override
    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        if(arg0 == null && arg1 == null) return true;
        else if (arg0 == null && arg1 != null ) return false;
        else return arg0.equals(arg1);
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        XMLType xmlType = null;
        String returnValue = null;
        try {
            xmlType = (XMLType) rs.getObject(names[0]);
            if (xmlType != null) {
                returnValue = xmlType.getStringVal();
            }
        } finally {
            if (null != xmlType) {
                xmlType.close();
            }
        }
        return returnValue;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        try {
            if (st.getConnection().getMetaData().getDatabaseProductName().equals("H2")) {
                st.setObject(index, (String) value);
            } else {
                if (value != null) {
                    st.setObject(index, XMLType.createXML(getOracleConnection(st.getConnection()), (String)value));
                }
            }
        } catch (Exception e) {
            throw new SQLException("Could not convert String to XML for storage: " + (String)value);
        }
    }

    private OracleConnection getOracleConnection(Connection conn) throws SQLException {
        CLOB tempClob = null;
        CallableStatement stmt = null;
        try {
            stmt = conn.prepareCall("{ call DBMS_LOB.CREATETEMPORARY(?, TRUE)}");
            stmt.registerOutParameter(1, java.sql.Types.CLOB);
            stmt.execute();
            tempClob = (CLOB)stmt.getObject(1);
            return tempClob.getConnection();
        } finally {
            if ( stmt != null ) {
                try {
                    stmt.close();
                } catch (Throwable e) {}
            }
        }
    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        if (o == null) return null;

        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        try {
            return (Serializable)o;
        }
        catch (Exception e) {
            throw new HibernateException("Could not disassemble Document to Serializable", e);
        }
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        try {
            return (String)serializable;
        }
        catch (Exception e) {
            throw new HibernateException("Could not assemble String to Document", e);
        }
    }

    @Override
    public Object replace(Object o, Object o1, Object o2) throws HibernateException {
        return o;
    }
}
