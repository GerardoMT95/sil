//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.13 at 06:00:36 PM CEST 
//


package it.eng.myportal.ws.rinnovoPatto.output;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.eng.myportal.ws.rinnovoPatto.output package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Descrizione_QNAME = new QName("", "descrizione");
    private final static QName _Codice_QNAME = new QName("", "codice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.eng.myportal.ws.rinnovoPatto.output
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Esito }
     * 
     */
    public Esito createEsito() {
        return new Esito();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "descrizione")
    public JAXBElement<String> createDescrizione(String value) {
        return new JAXBElement<String>(_Descrizione_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "codice")
    public JAXBElement<String> createCodice(String value) {
        return new JAXBElement<String>(_Codice_QNAME, String.class, null, value);
    }

}