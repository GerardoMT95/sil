//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.25 at 05:12:26 PM CEST 
//

package it.eng.sil.coop.webservices.agenda.appuntamento.xml.verifica.output;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import it.eng.sil.coop.webservices.agenda.appuntamento.xml.disponibilita.output.RispostaDisp;

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
 *         &lt;element name="Esito">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codice">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="descrizione">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="250"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="datiAppuntamento" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dataAppuntamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="oraAppuntamento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="5"/>
 *                         &lt;pattern value="[0-9]{2}:[0-9]{2}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IdCPI">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="9"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="denominazioneCPI">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="indirizzoCPI">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="indirizzoCPIstampa">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="600"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="siglaOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Ambiente" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="codStato">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "esito", "datiAppuntamento" })
@XmlRootElement(name = "RispostaVerificaApp")
public class RispostaVerifica {

	@XmlElement(name = "Esito", required = true)
	protected RispostaVerifica.Esito esito;
	protected RispostaVerifica.DatiAppuntamento datiAppuntamento;

	/**
	 * Gets the value of the esito property.
	 * 
	 * @return possible object is {@link RispostaDisp.Esito }
	 * 
	 */
	public RispostaVerifica.Esito getEsito() {
		return esito;
	}

	/**
	 * Sets the value of the esito property.
	 * 
	 * @param value
	 *            allowed object is {@link RispostaDisp.Esito }
	 * 
	 */
	public void setEsito(RispostaVerifica.Esito value) {
		this.esito = value;
	}

	/**
	 * Gets the value of the datiAppuntamento property.
	 * 
	 * @return possible object is {@link RispostaDisp.DatiAppuntamento }
	 * 
	 */
	public RispostaVerifica.DatiAppuntamento getDatiAppuntamento() {
		return datiAppuntamento;
	}

	/**
	 * Sets the value of the datiAppuntamento property.
	 * 
	 * @param value
	 *            allowed object is {@link RispostaDisp.DatiAppuntamento }
	 * 
	 */
	public void setDatiAppuntamento(RispostaVerifica.DatiAppuntamento value) {
		this.datiAppuntamento = value;
	}

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
	 *         &lt;element name="dataAppuntamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
	 *         &lt;element name="oraAppuntamento">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;length value="5"/>
	 *               &lt;pattern value="[0-9]{2}:[0-9]{2}"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="IdCPI">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;length value="9"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="denominazioneCPI">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="100"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="indirizzoCPI">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="100"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="indirizzoCPIstampa">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="600"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="siglaOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="Ambiente" minOccurs="0">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="100"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="codStato">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="8"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "dataAppuntamento", "oraAppuntamento", "idCPI", "denominazioneCPI",
			"indirizzoCPI", "indirizzoCPIstampa", "siglaOperatore", "ambiente", "codStato", "numMinuti" })
	public static class DatiAppuntamento {

		@XmlElement(required = true)
		protected XMLGregorianCalendar dataAppuntamento;
		@XmlElement(required = true)
		protected String oraAppuntamento;
		@XmlElement(name = "IdCPI", required = true)
		protected String idCPI;
		@XmlElement(required = true)
		protected String denominazioneCPI;
		@XmlElement(required = true)
		protected String indirizzoCPI;
		@XmlElement(required = true)
		protected String indirizzoCPIstampa;
		protected String siglaOperatore;
		@XmlElement(name = "Ambiente")
		protected String ambiente;
		@XmlElement(required = true)
		protected String codStato;
		@XmlElement(required = true)
		protected Integer numMinuti;

		/**
		 * Gets the value of the dataAppuntamento property.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public XMLGregorianCalendar getDataAppuntamento() {
			return dataAppuntamento;
		}

		/**
		 * Sets the value of the dataAppuntamento property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDataAppuntamento(XMLGregorianCalendar value) {
			this.dataAppuntamento = value;
		}

		/**
		 * Gets the value of the oraAppuntamento property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getOraAppuntamento() {
			return oraAppuntamento;
		}

		/**
		 * Sets the value of the oraAppuntamento property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setOraAppuntamento(String value) {
			this.oraAppuntamento = value;
		}

		/**
		 * Gets the value of the idCPI property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getIdCPI() {
			return idCPI;
		}

		/**
		 * Sets the value of the idCPI property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setIdCPI(String value) {
			this.idCPI = value;
		}

		/**
		 * Gets the value of the denominazioneCPI property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDenominazioneCPI() {
			return denominazioneCPI;
		}

		/**
		 * Sets the value of the denominazioneCPI property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDenominazioneCPI(String value) {
			this.denominazioneCPI = value;
		}

		/**
		 * Gets the value of the indirizzoCPI property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getIndirizzoCPI() {
			return indirizzoCPI;
		}

		/**
		 * Sets the value of the indirizzoCPI property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setIndirizzoCPI(String value) {
			this.indirizzoCPI = value;
		}

		/**
		 * Gets the value of the indirizzoCPIstampa property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getIndirizzoCPIstampa() {
			return indirizzoCPIstampa;
		}

		/**
		 * Sets the value of the indirizzoCPIstampa property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setIndirizzoCPIstampa(String value) {
			this.indirizzoCPIstampa = value;
		}

		/**
		 * Gets the value of the siglaOperatore property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getSiglaOperatore() {
			return siglaOperatore;
		}

		/**
		 * Sets the value of the siglaOperatore property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setSiglaOperatore(String value) {
			this.siglaOperatore = value;
		}

		/**
		 * Gets the value of the ambiente property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getAmbiente() {
			return ambiente;
		}

		/**
		 * Sets the value of the ambiente property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setAmbiente(String value) {
			this.ambiente = value;
		}

		/**
		 * Gets the value of the codStato property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodStato() {
			return codStato;
		}

		/**
		 * Sets the value of the codStato property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodStato(String value) {
			this.codStato = value;
		}

		public void setNumMinuti(Integer value) {
			this.numMinuti = value;
		}

		public Integer getNumMinuti() {
			return numMinuti;
		}

	}

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
	 *         &lt;element name="codice">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;length value="2"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="descrizione">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
	 *               &lt;maxLength value="250"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "codice", "descrizione" })
	public static class Esito {

		@XmlElement(required = true)
		protected String codice;
		@XmlElement(required = true)
		protected String descrizione;

		/**
		 * Gets the value of the codice property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodice() {
			return codice;
		}

		/**
		 * Sets the value of the codice property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodice(String value) {
			this.codice = value;
		}

		/**
		 * Gets the value of the descrizione property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDescrizione() {
			return descrizione;
		}

		/**
		 * Sets the value of the descrizione property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDescrizione(String value) {
			this.descrizione = value;
		}

	}

}
