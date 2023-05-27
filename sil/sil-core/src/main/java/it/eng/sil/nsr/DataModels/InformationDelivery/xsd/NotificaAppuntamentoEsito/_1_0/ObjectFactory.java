//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.27 at 02:23:06 PM CET 
//

package it.eng.sil.nsr.DataModels.InformationDelivery.xsd.NotificaAppuntamentoEsito._1_0;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * it.eng.sil.nsr.DataModels.InformationDelivery.xsd.NotificaAppuntamentoEsito._1_0 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _RichiestaNotificaEsito_QNAME = new QName(
			"http://nsr.sil.eng.it/DataModels/InformationDelivery/NotificaAppuntamentoEsito/1.0",
			"RichiestaNotificaEsito");
	private final static QName _RispostaNotificaEsito_QNAME = new QName(
			"http://nsr.sil.eng.it/DataModels/InformationDelivery/NotificaAppuntamentoEsito/1.0",
			"RispostaNotificaEsito");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * it.eng.sil.nsr.DataModels.InformationDelivery.xsd.NotificaAppuntamentoEsito._1_0
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link RichiestaNotificaEsitoType }
	 * 
	 */
	public RichiestaNotificaEsitoType createRichiestaNotificaEsitoType() {
		return new RichiestaNotificaEsitoType();
	}

	/**
	 * Create an instance of {@link RispostaNotificaEsitoType }
	 * 
	 */
	public RispostaNotificaEsitoType createRispostaNotificaEsitoType() {
		return new RispostaNotificaEsitoType();
	}

	/**
	 * Create an instance of {@link NuovoAppuntamentoType }
	 * 
	 */
	public NuovoAppuntamentoType createNuovoAppuntamentoType() {
		return new NuovoAppuntamentoType();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RichiestaNotificaEsitoType }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://nsr.sil.eng.it/DataModels/InformationDelivery/NotificaAppuntamentoEsito/1.0", name = "RichiestaNotificaEsito")
	public JAXBElement<RichiestaNotificaEsitoType> createRichiestaNotificaEsito(RichiestaNotificaEsitoType value) {
		return new JAXBElement<RichiestaNotificaEsitoType>(_RichiestaNotificaEsito_QNAME,
				RichiestaNotificaEsitoType.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link RispostaNotificaEsitoType }{@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://nsr.sil.eng.it/DataModels/InformationDelivery/NotificaAppuntamentoEsito/1.0", name = "RispostaNotificaEsito")
	public JAXBElement<RispostaNotificaEsitoType> createRispostaNotificaEsito(RispostaNotificaEsitoType value) {
		return new JAXBElement<RispostaNotificaEsitoType>(_RispostaNotificaEsito_QNAME, RispostaNotificaEsitoType.class,
				null, value);
	}

}
