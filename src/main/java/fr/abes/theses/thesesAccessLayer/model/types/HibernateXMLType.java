package fr.abes.theses.thesesAccessLayer.model.types;

import com.zaxxer.hikari.pool.HikariProxyResultSet;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.sql.CLOB;
import oracle.xdb.XMLType;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;

public class HibernateXMLType implements UserType, Serializable {
    private static final Class returnedClass = Document.class;
    private static final int[] SQL_TYPES = new int[]{oracle.xdb.XMLType._SQL_TYPECODE};

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
        else if (x == null && y != null) return false;
        else return x.equals(y);
    }


    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        XMLType xmlType = null;
        org.w3c.dom.Document doc = null;
        try {
            SQLXML op = null;
            OracleResultSet ors = null;
            if (rs instanceof OracleResultSet) {
                ors = (OracleResultSet) rs;
            } else {
                throw new UnsupportedOperationException("ResultSet needs to be of type OracleResultSet");
            }
            op = ors.getSQLXML(names[0]);
            if (op != null) {
                xmlType = XMLType.createXML(getOracleConnection(session.connection()), op.getString());
            }
            doc = xmlType.getDOM();
        } finally {
            if (null != xmlType) {
                xmlType.close();
            }
        }
        return doc;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        try {
            XMLType xmlType = null;
            if (value != null) {
                xmlType = XMLType.createXML(st.getConnection(), domToString((Document) value));
            }
            st.setObject(index, xmlType);
        } catch (Exception e) {
            throw new SQLException("Could not convert Document to String for storage");
        }
    }

    public static String domToString(Document _document)
            throws TransformerException {
        TransformerFactory tFactory = new net.sf.saxon.TransformerFactoryImpl();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource in = new DOMSource(_document);
        transformer.transform(in, new javax.xml.transform.stream.StreamResult(out));
        return out.toString();
    }

    public static Document stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xmlSource.getBytes("UTF-8")));
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
            return (Serializable) value;
        } catch (Exception e) {
            throw new HibernateException("Could not disassemble Document to Serializable", e);
        }
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        try {
            return stringToDom((String) cached);
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
            tempClob = (CLOB) stmt.getObject(1);
            return tempClob.getConnection();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Throwable e) {
                }
            }
        }
    }
}
