package fr.abes.theses.thesesAccessLayer.model.types;

import oracle.jdbc.OracleResultSet;
import oracle.sql.OPAQUE;
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
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HibernateXmlType implements UserType, Serializable {

    private static final long serialVersionUID = 2308230823023l;
    private static final Class returnedClass = Document.class;
    private static final int[] SQL_TYPES = {oracle.xdb.XMLType._SQL_TYPECODE};

    @Override
    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    @Override
    public Class returnedClass() {
        return returnedClass;
    }

    @Override
    public int hashCode(Object _obj) {
        return _obj.hashCode();
    }

    @Override
    public Object assemble(Serializable _cached, Object _owner)
            throws HibernateException {
        try {
            return HibernateXmlType.stringToDom((String) _cached);
        } catch (Exception e) {
            throw new HibernateException("Could not assemble String to Document", e);
        }
    }

    @Override
    public Serializable disassemble(Object _obj)
            throws HibernateException {
        try {
            return HibernateXmlType.domToString((Document) _obj);
        } catch (Exception e) {
            throw new HibernateException("Could not disassemble Document to Serializable", e);
        }
    }

    @Override
    public Object replace(Object _orig, Object _tar, Object _owner) {
        return deepCopy(_orig);
    }

    @Override
    public boolean equals(Object arg0, Object arg1)
            throws HibernateException {
        if (arg0 == null && arg1 == null) return true;
        else if (arg0 == null && arg1 != null) return false;
        else return arg0.equals(arg1);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor var3, Object var4)
            throws HibernateException, SQLException
    {
        XMLType xmlType = null;
        Document doc;
        try {
            OPAQUE op;
            OracleResultSet ors;
            if (rs instanceof OracleResultSet) {
                ors = (OracleResultSet)rs;
            } else {
                throw new UnsupportedOperationException("ResultSet needs to be of type OracleResultSet");
            }
            op = ors.getOPAQUE(names[0]);
            if(op != null) {
                xmlType = XMLType.createXML ( op );
            }
            doc = xmlType.getDOM();
        }finally {
            if (null != xmlType) {
                xmlType.close();
            }
        }
        return doc;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor var4)
            throws HibernateException, SQLException
    {
        try {
            XMLType xmlType = null;
            if (value != null) {
                xmlType = XMLType.createXML(st.getConnection(),HibernateXmlType.domToString((Document)value));
            }
            st.setObject(index, xmlType);
        }
        catch (Exception e) {
            throw new SQLException("Could not convert Document to String for storage");
        }
    }

    @Override
    public Object deepCopy(Object value)
            throws HibernateException {
        if (value == null) return null;

        return ((Document) value).cloneNode(true);
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    protected static String domToString(Document _document)
            throws TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(_document);
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);
        transformer.transform(source, result);
        return sw.toString();
    }

    protected static Document stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xmlSource.getBytes("UTF-8")));
    }

}
