package fr.abes.theses.thesesAccessLayer.model.types;

import oracle.jdbc.OracleConnection;
import oracle.sql.CLOB;
import oracle.xdb.XMLType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.jdom2.Document;

import java.io.Serializable;
import java.sql.*;

public class HibernateXMLType implements UserType {
        private static final Class returnedClass = String.class;
        private static final int[] SQL_TYPES = new int[] { oracle.xdb.XMLType._SQL_TYPECODE };

        @Override
        public int[] sqlTypes() {
            return SQL_TYPES;
        }

        @Override
        public Class returnedClass() {
            return returnedClass;
        }

        @Override
        public boolean equals(Object x, Object y) throws HibernateException {
            if (x == null && y == null) return true;
            else if (x == null && y != null ) return false;
            else return x.equals(y);
        }


        @Override
        public int hashCode(Object x) throws HibernateException {
            return x.hashCode();
        }

        @Override
        public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {

            XMLType xmlType = null;
            Document doc = null;
            String returnValue = null;
            try {
                //logger.debug("rs type: " + rs.getClass().getName() + ", value: " + rs.getObject(names[0]));
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
        public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
            try {
                XMLType xmlType = null;
                if (value != null) {
                    xmlType = XMLType.createXML(getOracleConnection(st.getConnection()), (String)value);
                }
                st.setObject(index, xmlType);
            } catch (Exception e) {
                throw new SQLException("Could not convert String to XML for storage: " + (String)value);
            }
        }


        @Override
        public Object deepCopy(Object value) throws HibernateException {
            if (value == null) {
                return null;
            } else {
                return value;
            }
        }

        @Override
        public boolean isMutable() {
            return false;
        }

        @Override
        public Serializable disassemble(Object value) throws HibernateException {
            try {
                return (Serializable)value;
            } catch (Exception e) {
                throw new HibernateException("Could not disassemble Document to Serializable", e);
            }
        }

        @Override
        public Object assemble(Serializable cached, Object owner) throws HibernateException {

            try {
                return (String)cached;
            } catch (Exception e) {
                throw new HibernateException("Could not assemble String to Document", e);
            }
        }

        @Override
        public Object replace(Object original, Object target, Object owner) throws HibernateException {
            return original;
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
}