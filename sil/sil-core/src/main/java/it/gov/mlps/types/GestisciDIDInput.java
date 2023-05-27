//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.22 at 03:13:58 PM CET 
//

package it.gov.mlps.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for GestisciDID_Input complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GestisciDID_Input">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VariabiliDiProfiling" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}VariabiliDiProfiling"/>
 *         &lt;element name="InformazioniDID" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}InformazioniDID"/>
 *         &lt;element name="GUIDOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CodiceFiscaleOperatore" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Applicazione" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}Applicazione"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GestisciDID_Input", propOrder = { "variabiliDiProfiling", "informazioniDID", "guidOperatore",
		"codiceFiscaleOperatore", "applicazione" })
@XmlRootElement(name = "GestisciDID_Input")
public class GestisciDIDInput {

	@XmlElement(name = "VariabiliDiProfiling", required = true, nillable = true)
	protected VariabiliDiProfiling variabiliDiProfiling;
	@XmlElement(name = "InformazioniDID", required = true)
	protected InformazioniDID informazioniDID;
	@XmlElement(name = "GUIDOperatore", required = true, nillable = true)
	protected String guidOperatore;
	@XmlElement(name = "CodiceFiscaleOperatore", required = true, nillable = true)
	protected String codiceFiscaleOperatore;
	@XmlElement(name = "Applicazione", required = true)
	protected Applicazione applicazione;

	/**
	 * Gets the value of the variabiliDiProfiling property.
	 * 
	 * @return possible object is {@link VariabiliDiProfiling }
	 * 
	 */
	public VariabiliDiProfiling getVariabiliDiProfiling() {
		return variabiliDiProfiling;
	}

	/**
	 * Sets the value of the variabiliDiProfiling property.
	 * 
	 * @param value
	 *            allowed object is {@link VariabiliDiProfiling }
	 * 
	 */
	public void setVariabiliDiProfiling(VariabiliDiProfiling value) {
		this.variabiliDiProfiling = value;
	}

	/**
	 * Gets the value of the informazioniDID property.
	 * 
	 * @return possible object is {@link InformazioniDID }
	 * 
	 */
	public InformazioniDID getInformazioniDID() {
		return informazioniDID;
	}

	/**
	 * Sets the value of the informazioniDID property.
	 * 
	 * @param value
	 *            allowed object is {@link InformazioniDID }
	 * 
	 */
	public void setInformazioniDID(InformazioniDID value) {
		this.informazioniDID = value;
	}

	/**
	 * Gets the value of the guidOperatore property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGUIDOperatore() {
		return guidOperatore;
	}

	/**
	 * Sets the value of the guidOperatore property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGUIDOperatore(String value) {
		this.guidOperatore = value;
	}

	/**
	 * Gets the value of the codiceFiscaleOperatore property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodiceFiscaleOperatore() {
		return codiceFiscaleOperatore;
	}

	/**
	 * Sets the value of the codiceFiscaleOperatore property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodiceFiscaleOperatore(String value) {
		this.codiceFiscaleOperatore = value;
	}

	/**
	 * Gets the value of the applicazione property.
	 * 
	 * @return possible object is {@link Applicazione }
	 * 
	 */
	public Applicazione getApplicazione() {
		return applicazione;
	}

	/**
	 * Sets the value of the applicazione property.
	 * 
	 * @param value
	 *            allowed object is {@link Applicazione }
	 * 
	 */
	public void setApplicazione(Applicazione value) {
		this.applicazione = value;
	}

}