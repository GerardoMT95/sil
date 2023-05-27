//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.15 at 10:27:10 AM CET 
//

package it.eng.myportal.siler.appuntamento.disponibilitaAppuntamento.output;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

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
 *         &lt;element name="ElencoDisponibilita" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dataRif" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="datiAppuntamento" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="identificativoSlot" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                             &lt;element name="dataAppuntamento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="oraAppuntamento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;length value="5"/>
 *                                   &lt;pattern value="[0-9]{2}:[0-9]{2}"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="IdCPI">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;length value="9"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="denominazioneCPI">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="indirizzoCPI">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="indirizzoCPIstampa">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="600"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="siglaOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Ambiente" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
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
@XmlType(name = "", propOrder = { "esito", "elencoDisponibilita" })
@XmlRootElement(name = "Risposta")
public class Risposta {

	@XmlElement(name = "Esito", required = true)
	protected Risposta.Esito esito;
	@XmlElement(name = "ElencoDisponibilita")
	protected Risposta.ElencoDisponibilita elencoDisponibilita;

	/**
	 * Gets the value of the esito property.
	 * 
	 * @return possible object is {@link Risposta.Esito }
	 * 
	 */
	public Risposta.Esito getEsito() {
		return esito;
	}

	/**
	 * Sets the value of the esito property.
	 * 
	 * @param value
	 *            allowed object is {@link Risposta.Esito }
	 * 
	 */
	public void setEsito(Risposta.Esito value) {
		this.esito = value;
	}

	/**
	 * Gets the value of the elencoDisponibilita property.
	 * 
	 * @return possible object is {@link Risposta.ElencoDisponibilita }
	 * 
	 */
	public Risposta.ElencoDisponibilita getElencoDisponibilita() {
		return elencoDisponibilita;
	}

	/**
	 * Sets the value of the elencoDisponibilita property.
	 * 
	 * @param value
	 *            allowed object is {@link Risposta.ElencoDisponibilita }
	 * 
	 */
	public void setElencoDisponibilita(Risposta.ElencoDisponibilita value) {
		this.elencoDisponibilita = value;
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
	 *         &lt;element name="dataRif" type="{http://www.w3.org/2001/XMLSchema}date"/>
	 *         &lt;element name="datiAppuntamento" maxOccurs="unbounded">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="identificativoSlot" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
	@XmlType(name = "", propOrder = { "dataRif", "datiAppuntamento" })
	public static class ElencoDisponibilita {

		@XmlElement(required = true)
		@XmlSchemaType(name = "date")
		protected XMLGregorianCalendar dataRif;
		@XmlElement(required = true)
		protected List<Risposta.ElencoDisponibilita.DatiAppuntamento> datiAppuntamento;

		/**
		 * Gets the value of the dataRif property.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public XMLGregorianCalendar getDataRif() {
			return dataRif;
		}

		/**
		 * Sets the value of the dataRif property.
		 * 
		 * @param value
		 *            allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDataRif(XMLGregorianCalendar value) {
			this.dataRif = value;
		}

		/**
		 * Gets the value of the datiAppuntamento property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you
		 * make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
		 * method for the datiAppuntamento property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getDatiAppuntamento().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link Risposta.ElencoDisponibilita.DatiAppuntamento }
		 * 
		 * 
		 */
		public List<Risposta.ElencoDisponibilita.DatiAppuntamento> getDatiAppuntamento() {
			if (datiAppuntamento == null) {
				datiAppuntamento = new ArrayList<Risposta.ElencoDisponibilita.DatiAppuntamento>();
			}
			return this.datiAppuntamento;
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
		 *         &lt;element name="identificativoSlot" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "identificativoSlot", "dataAppuntamento", "oraAppuntamento", "idCPI",
				"denominazioneCPI", "indirizzoCPI", "indirizzoCPIstampa", "siglaOperatore", "ambiente" })
		public static class DatiAppuntamento {

			@XmlElement(required = true)
			protected BigInteger identificativoSlot;
			@XmlElement(required = true)
			@XmlSchemaType(name = "date")
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
			@XmlElement(name = "ambiente")
			protected String ambiente;

			/**
			 * Gets the value of the identificativoSlot property.
			 * 
			 * @return possible object is {@link BigInteger }
			 * 
			 */
			public BigInteger getIdentificativoSlot() {
				return identificativoSlot;
			}

			/**
			 * Sets the value of the identificativoSlot property.
			 * 
			 * @param value
			 *            allowed object is {@link BigInteger }
			 * 
			 */
			public void setIdentificativoSlot(BigInteger value) {
				this.identificativoSlot = value;
			}

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
