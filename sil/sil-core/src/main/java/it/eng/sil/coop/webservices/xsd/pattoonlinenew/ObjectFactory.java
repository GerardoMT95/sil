//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.10 at 03:35:13 PM CEST 
//

package it.eng.sil.coop.webservices.xsd.pattoonlinenew;

import javax.xml.bind.annotation.XmlRegistry;

import it.eng.sil.coop.webservices.xsd.pattoonline.EsitoType;
import it.eng.sil.coop.webservices.xsd.pattoonline.PattoAccettatoType;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * it.eng.sil.coop.webservices.xsd.pattoonlinenew package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * it.eng.sil.coop.webservices.xsd.pattoonlinenew
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link AccettazionePattoType }
	 * 
	 */
	public AccettazionePattoType createAccettazionePattoType() {
		return new AccettazionePattoType();
	}

	/**
	 * Create an instance of {@link PattoType }
	 * 
	 */
	public PattoType createPattoType() {
		return new PattoType();
	}

	/**
	 * Create an instance of {@link EsitoType }
	 * 
	 */
	public EsitoType createEsitoType() {
		return new EsitoType();
	}

	/**
	 * Create an instance of {@link PattoAccettatoType }
	 * 
	 */
	public PattoAccettatoType createPattoAccettatoType() {
		return new PattoAccettatoType();
	}

}
