//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.10 at 04:21:13 PM CEST 
//

package it.eng.sil.coop.webservices.xsd.pattoonline;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * it.eng.sil.coop.webservices.xsd.pattoonline package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _RequestAggiornaPatto_QNAME = new QName(
			"http://pattoonline.webservices.coop.sil.eng.it/", "RequestAggiornaPatto");
	private final static QName _ResponseAggiornaPatto_QNAME = new QName(
			"http://pattoonline.webservices.coop.sil.eng.it/", "ResponseAggiornaPatto");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * it.eng.sil.coop.webservices.xsd.pattoonline
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link PattoAccettatoType }
	 * 
	 */
	public PattoAccettatoType createPattoAccettatoType() {
		return new PattoAccettatoType();
	}

	/**
	 * Create an instance of {@link PattoType }
	 * 
	 */
	public PattoType createPattoType() {
		return new PattoType();
	}

	/**
	 * Create an instance of {@link AccettazionePattoType }
	 * 
	 */
	public AccettazionePattoType createAccettazionePattoType() {
		return new AccettazionePattoType();
	}

	/**
	 * Create an instance of {@link EsitoType }
	 * 
	 */
	public EsitoType createEsitoType() {
		return new EsitoType();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link PattoAccettatoType }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://pattoonline.webservices.coop.sil.eng.it/", name = "RequestAggiornaPatto")
	public JAXBElement<PattoAccettatoType> createRequestAggiornaPatto(PattoAccettatoType value) {
		return new JAXBElement<PattoAccettatoType>(_RequestAggiornaPatto_QNAME, PattoAccettatoType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link EsitoType }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://pattoonline.webservices.coop.sil.eng.it/", name = "ResponseAggiornaPatto")
	public JAXBElement<EsitoType> createResponseAggiornaPatto(EsitoType value) {
		return new JAXBElement<EsitoType>(_ResponseAggiornaPatto_QNAME, EsitoType.class, null, value);
	}

}