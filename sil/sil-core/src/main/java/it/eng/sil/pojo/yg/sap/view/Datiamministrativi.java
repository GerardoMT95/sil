//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.04 at 03:01:56 PM CEST 
//

package it.eng.sil.pojo.yg.sap.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}statoinanagrafe" minOccurs="0"/>
 *         &lt;element ref="{}periodidisoccupazione" minOccurs="0"/>
 *         &lt;element ref="{}listespeciali_lst" minOccurs="0"/>
 *         &lt;element ref="{}assolvimentoistruzione" minOccurs="0"/>
 *         &lt;element ref="{}altrenotizie" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "statoinanagrafe", "periodidisoccupazione", "listespecialiLst",
		"assolvimentoistruzione", "altrenotizie" })
@XmlRootElement(name = "datiamministrativi")
public class Datiamministrativi {

	protected Statoinanagrafe statoinanagrafe;
	protected Periodidisoccupazione periodidisoccupazione;
	@XmlElement(name = "listespeciali_lst")
	protected ListespecialiLst listespecialiLst;
	protected Assolvimentoistruzione assolvimentoistruzione;
	protected Altrenotizie altrenotizie;

	/**
	 * Gets the value of the statoinanagrafe property.
	 * 
	 * @return possible object is {@link Statoinanagrafe }
	 * 
	 */
	public Statoinanagrafe getStatoinanagrafe() {
		return statoinanagrafe;
	}

	/**
	 * Sets the value of the statoinanagrafe property.
	 * 
	 * @param value
	 *            allowed object is {@link Statoinanagrafe }
	 * 
	 */
	public void setStatoinanagrafe(Statoinanagrafe value) {
		this.statoinanagrafe = value;
	}

	/**
	 * Gets the value of the periodidisoccupazione property.
	 * 
	 * @return possible object is {@link Periodidisoccupazione }
	 * 
	 */
	public Periodidisoccupazione getPeriodidisoccupazione() {
		return periodidisoccupazione;
	}

	/**
	 * Sets the value of the periodidisoccupazione property.
	 * 
	 * @param value
	 *            allowed object is {@link Periodidisoccupazione }
	 * 
	 */
	public void setPeriodidisoccupazione(Periodidisoccupazione value) {
		this.periodidisoccupazione = value;
	}

	/**
	 * Gets the value of the listespecialiLst property.
	 * 
	 * @return possible object is {@link ListespecialiLst }
	 * 
	 */
	public ListespecialiLst getListespecialiLst() {
		return listespecialiLst;
	}

	/**
	 * Sets the value of the listespecialiLst property.
	 * 
	 * @param value
	 *            allowed object is {@link ListespecialiLst }
	 * 
	 */
	public void setListespecialiLst(ListespecialiLst value) {
		this.listespecialiLst = value;
	}

	/**
	 * Gets the value of the assolvimentoistruzione property.
	 * 
	 * @return possible object is {@link Assolvimentoistruzione }
	 * 
	 */
	public Assolvimentoistruzione getAssolvimentoistruzione() {
		return assolvimentoistruzione;
	}

	/**
	 * Sets the value of the assolvimentoistruzione property.
	 * 
	 * @param value
	 *            allowed object is {@link Assolvimentoistruzione }
	 * 
	 */
	public void setAssolvimentoistruzione(Assolvimentoistruzione value) {
		this.assolvimentoistruzione = value;
	}

	/**
	 * Gets the value of the altrenotizie property.
	 * 
	 * @return possible object is {@link Altrenotizie }
	 * 
	 */
	public Altrenotizie getAltrenotizie() {
		return altrenotizie;
	}

	/**
	 * Sets the value of the altrenotizie property.
	 * 
	 * @param value
	 *            allowed object is {@link Altrenotizie }
	 * 
	 */
	public void setAltrenotizie(Altrenotizie value) {
		this.altrenotizie = value;
	}

}