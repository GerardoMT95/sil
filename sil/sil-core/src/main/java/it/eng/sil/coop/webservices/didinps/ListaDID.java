//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.29 at 12:09:08 PM CEST 
//

package it.eng.sil.coop.webservices.didinps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element name="IdComunicazione" type="{}Max_40_Caratteri"/>
 *         &lt;element name="DataInvio" type="{}Data"/>
 *         &lt;element name="DID">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TipoOperazione" type="{}Tipo_Operazione"/>
 *                   &lt;element name="CodiceFiscale" type="{}Codice_Fiscale"/>
 *                   &lt;element name="Cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Cittadinanza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DataDichiarazione" type="{}Data"/>
 *                   &lt;element name="CodiceUnivocoCPI" type="{}CodiceCPI_MLPS"/>
 *                   &lt;element name="Protocollo" type="{}ProtocolloINPS"/>
 *                   &lt;choice maxOccurs="2">
 *                     &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                     &lt;element name="Cellulare" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;/choice>
 *                   &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="EmailPatronato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DataInizioDisoccupazione" type="{}Data" minOccurs="0"/>
 *                   &lt;element name="DenominazioneAzienda" type="{}Max_250_Caratteri"/>
 *                   &lt;element name="CodiceFiscalePIVAUltimaAzienda" type="{}Codice_Fiscale_PIVA" minOccurs="0"/>
 *                   &lt;element name="UltimaQualifica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="DataInizioAttivitaAutonoma" type="{}Data" minOccurs="0"/>
 *                   &lt;element name="DataInizioAttivitaSubord" type="{}Data" minOccurs="0"/>
 *                   &lt;element name="DataInizioAttivitaParaSub" type="{}Data" minOccurs="0"/>
 *                   &lt;element name="DataInizioAttivitaAccess" type="{}Data" minOccurs="0"/>
 *                   &lt;element name="RedditoLavoroAutonoma" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="RedditoLavoroSubordinato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="RedditoLavoroParaSubord" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="RedditoLavoroAccess" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                   &lt;element name="CodiceComuneDomicilio" type="{}Cod_Comune_Domicilio"/>
 *                   &lt;element name="ComuneDomicilio" type="{}Comune_Domicilio"/>
 *                   &lt;element name="ProvinciaDomicilio" type="{}Provincia_Domicilio"/>
 *                   &lt;element name="IndirizzoDomicilio" type="{}Indirizzo_Domicilio"/>
 *                   &lt;element name="CapDomicilio" type="{}Cap_Domicilio"/>
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
@XmlType(name = "", propOrder = { "idComunicazione", "dataInvio", "did" })
@XmlRootElement(name = "ListaDID")
public class ListaDID {

	@XmlElement(name = "IdComunicazione", required = true)
	protected String idComunicazione;
	@XmlElement(name = "DataInvio", required = true)
	protected String dataInvio;
	@XmlElement(name = "DID", required = true)
	protected ListaDID.DID did;

	/**
	 * Gets the value of the idComunicazione property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdComunicazione() {
		return idComunicazione;
	}

	/**
	 * Sets the value of the idComunicazione property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdComunicazione(String value) {
		this.idComunicazione = value;
	}

	/**
	 * Gets the value of the dataInvio property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDataInvio() {
		return dataInvio;
	}

	/**
	 * Sets the value of the dataInvio property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDataInvio(String value) {
		this.dataInvio = value;
	}

	/**
	 * Gets the value of the did property.
	 * 
	 * @return possible object is {@link ListaDID.DID }
	 * 
	 */
	public ListaDID.DID getDID() {
		return did;
	}

	/**
	 * Sets the value of the did property.
	 * 
	 * @param value
	 *            allowed object is {@link ListaDID.DID }
	 * 
	 */
	public void setDID(ListaDID.DID value) {
		this.did = value;
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
	 *         &lt;element name="TipoOperazione" type="{}Tipo_Operazione"/>
	 *         &lt;element name="CodiceFiscale" type="{}Codice_Fiscale"/>
	 *         &lt;element name="Cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="Nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="Cittadinanza" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="DataDichiarazione" type="{}Data"/>
	 *         &lt;element name="CodiceUnivocoCPI" type="{}CodiceCPI_MLPS"/>
	 *         &lt;element name="Protocollo" type="{}ProtocolloINPS"/>
	 *         &lt;choice maxOccurs="2">
	 *           &lt;element name="Telefono" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *           &lt;element name="Cellulare" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;/choice>
	 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="EmailPatronato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="DataInizioDisoccupazione" type="{}Data" minOccurs="0"/>
	 *         &lt;element name="DenominazioneAzienda" type="{}Max_250_Caratteri"/>
	 *         &lt;element name="CodiceFiscalePIVAUltimaAzienda" type="{}Codice_Fiscale_PIVA" minOccurs="0"/>
	 *         &lt;element name="UltimaQualifica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="DataInizioAttivitaAutonoma" type="{}Data" minOccurs="0"/>
	 *         &lt;element name="DataInizioAttivitaSubord" type="{}Data" minOccurs="0"/>
	 *         &lt;element name="DataInizioAttivitaParaSub" type="{}Data" minOccurs="0"/>
	 *         &lt;element name="DataInizioAttivitaAccess" type="{}Data" minOccurs="0"/>
	 *         &lt;element name="RedditoLavoroAutonoma" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *         &lt;element name="RedditoLavoroSubordinato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *         &lt;element name="RedditoLavoroParaSubord" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *         &lt;element name="RedditoLavoroAccess" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *         &lt;element name="CodiceComuneDomicilio" type="{}Cod_Comune_Domicilio"/>
	 *         &lt;element name="ComuneDomicilio" type="{}Comune_Domicilio"/>
	 *         &lt;element name="ProvinciaDomicilio" type="{}Provincia_Domicilio"/>
	 *         &lt;element name="IndirizzoDomicilio" type="{}Indirizzo_Domicilio"/>
	 *         &lt;element name="CapDomicilio" type="{}Cap_Domicilio"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "tipoOperazione", "codiceFiscale", "cognome", "nome", "cittadinanza",
			"dataDichiarazione", "codiceUnivocoCPI", "protocollo", "telefonoOrCellulare", "email", "emailPatronato",
			"dataInizioDisoccupazione", "denominazioneAzienda", "codiceFiscalePIVAUltimaAzienda", "ultimaQualifica",
			"dataInizioAttivitaAutonoma", "dataInizioAttivitaSubord", "dataInizioAttivitaParaSub",
			"dataInizioAttivitaAccess", "redditoLavoroAutonoma", "redditoLavoroSubordinato", "redditoLavoroParaSubord",
			"redditoLavoroAccess", "codiceComuneDomicilio", "comuneDomicilio", "provinciaDomicilio",
			"indirizzoDomicilio", "capDomicilio" })
	public static class DID {

		@XmlElement(name = "TipoOperazione", required = true)
		protected TipoOperazione tipoOperazione;
		@XmlElement(name = "CodiceFiscale", required = true)
		protected String codiceFiscale;
		@XmlElement(name = "Cognome", required = true)
		protected String cognome;
		@XmlElement(name = "Nome", required = true)
		protected String nome;
		@XmlElement(name = "Cittadinanza", required = true)
		protected String cittadinanza;
		@XmlElement(name = "DataDichiarazione", required = true)
		protected String dataDichiarazione;
		@XmlElement(name = "CodiceUnivocoCPI", required = true)
		protected String codiceUnivocoCPI;
		@XmlElement(name = "Protocollo", required = true)
		protected String protocollo;
		@XmlElementRefs({ @XmlElementRef(name = "Cellulare", type = JAXBElement.class),
				@XmlElementRef(name = "Telefono", type = JAXBElement.class) })
		protected List<JAXBElement<String>> telefonoOrCellulare;
		@XmlElement(name = "Email")
		protected String email;
		@XmlElement(name = "EmailPatronato")
		protected String emailPatronato;
		@XmlElement(name = "DataInizioDisoccupazione")
		protected String dataInizioDisoccupazione;
		@XmlElement(name = "DenominazioneAzienda", required = true)
		protected String denominazioneAzienda;
		@XmlElement(name = "CodiceFiscalePIVAUltimaAzienda")
		protected String codiceFiscalePIVAUltimaAzienda;
		@XmlElement(name = "UltimaQualifica")
		protected String ultimaQualifica;
		@XmlElement(name = "DataInizioAttivitaAutonoma")
		protected String dataInizioAttivitaAutonoma;
		@XmlElement(name = "DataInizioAttivitaSubord")
		protected String dataInizioAttivitaSubord;
		@XmlElement(name = "DataInizioAttivitaParaSub")
		protected String dataInizioAttivitaParaSub;
		@XmlElement(name = "DataInizioAttivitaAccess")
		protected String dataInizioAttivitaAccess;
		@XmlElement(name = "RedditoLavoroAutonoma")
		protected BigDecimal redditoLavoroAutonoma;
		@XmlElement(name = "RedditoLavoroSubordinato")
		protected BigDecimal redditoLavoroSubordinato;
		@XmlElement(name = "RedditoLavoroParaSubord")
		protected BigDecimal redditoLavoroParaSubord;
		@XmlElement(name = "RedditoLavoroAccess")
		protected BigDecimal redditoLavoroAccess;
		@XmlElement(name = "CodiceComuneDomicilio", required = true)
		protected String codiceComuneDomicilio;
		@XmlElement(name = "ComuneDomicilio", required = true)
		protected String comuneDomicilio;
		@XmlElement(name = "ProvinciaDomicilio", required = true)
		protected String provinciaDomicilio;
		@XmlElement(name = "IndirizzoDomicilio", required = true)
		protected String indirizzoDomicilio;
		@XmlElement(name = "CapDomicilio", required = true)
		protected String capDomicilio;

		/**
		 * Gets the value of the tipoOperazione property.
		 * 
		 * @return possible object is {@link TipoOperazione }
		 * 
		 */
		public TipoOperazione getTipoOperazione() {
			return tipoOperazione;
		}

		/**
		 * Sets the value of the tipoOperazione property.
		 * 
		 * @param value
		 *            allowed object is {@link TipoOperazione }
		 * 
		 */
		public void setTipoOperazione(TipoOperazione value) {
			this.tipoOperazione = value;
		}

		/**
		 * Gets the value of the codiceFiscale property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodiceFiscale() {
			return codiceFiscale;
		}

		/**
		 * Sets the value of the codiceFiscale property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodiceFiscale(String value) {
			this.codiceFiscale = value;
		}

		/**
		 * Gets the value of the cognome property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCognome() {
			return cognome;
		}

		/**
		 * Sets the value of the cognome property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCognome(String value) {
			this.cognome = value;
		}

		/**
		 * Gets the value of the nome property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNome() {
			return nome;
		}

		/**
		 * Sets the value of the nome property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setNome(String value) {
			this.nome = value;
		}

		/**
		 * Gets the value of the cittadinanza property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCittadinanza() {
			return cittadinanza;
		}

		/**
		 * Sets the value of the cittadinanza property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCittadinanza(String value) {
			this.cittadinanza = value;
		}

		/**
		 * Gets the value of the dataDichiarazione property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataDichiarazione() {
			return dataDichiarazione;
		}

		/**
		 * Sets the value of the dataDichiarazione property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataDichiarazione(String value) {
			this.dataDichiarazione = value;
		}

		/**
		 * Gets the value of the codiceUnivocoCPI property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodiceUnivocoCPI() {
			return codiceUnivocoCPI;
		}

		/**
		 * Sets the value of the codiceUnivocoCPI property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodiceUnivocoCPI(String value) {
			this.codiceUnivocoCPI = value;
		}

		/**
		 * Gets the value of the protocollo property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getProtocollo() {
			return protocollo;
		}

		/**
		 * Sets the value of the protocollo property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setProtocollo(String value) {
			this.protocollo = value;
		}

		/**
		 * Gets the value of the telefonoOrCellulare property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you
		 * make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
		 * method for the telefonoOrCellulare property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getTelefonoOrCellulare().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list {@link JAXBElement }{@code <}{@link String
		 * }{@code >} {@link JAXBElement }{@code <}{@link String }{@code >}
		 * 
		 * 
		 */
		public List<JAXBElement<String>> getTelefonoOrCellulare() {
			if (telefonoOrCellulare == null) {
				telefonoOrCellulare = new ArrayList<JAXBElement<String>>();
			}
			return this.telefonoOrCellulare;
		}

		/**
		 * Gets the value of the email property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * Sets the value of the email property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setEmail(String value) {
			this.email = value;
		}

		/**
		 * Gets the value of the emailPatronato property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getEmailPatronato() {
			return emailPatronato;
		}

		/**
		 * Sets the value of the emailPatronato property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setEmailPatronato(String value) {
			this.emailPatronato = value;
		}

		/**
		 * Gets the value of the dataInizioDisoccupazione property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataInizioDisoccupazione() {
			return dataInizioDisoccupazione;
		}

		/**
		 * Sets the value of the dataInizioDisoccupazione property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataInizioDisoccupazione(String value) {
			this.dataInizioDisoccupazione = value;
		}

		/**
		 * Gets the value of the denominazioneAzienda property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDenominazioneAzienda() {
			return denominazioneAzienda;
		}

		/**
		 * Sets the value of the denominazioneAzienda property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDenominazioneAzienda(String value) {
			this.denominazioneAzienda = value;
		}

		/**
		 * Gets the value of the codiceFiscalePIVAUltimaAzienda property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodiceFiscalePIVAUltimaAzienda() {
			return codiceFiscalePIVAUltimaAzienda;
		}

		/**
		 * Sets the value of the codiceFiscalePIVAUltimaAzienda property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodiceFiscalePIVAUltimaAzienda(String value) {
			this.codiceFiscalePIVAUltimaAzienda = value;
		}

		/**
		 * Gets the value of the ultimaQualifica property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getUltimaQualifica() {
			return ultimaQualifica;
		}

		/**
		 * Sets the value of the ultimaQualifica property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setUltimaQualifica(String value) {
			this.ultimaQualifica = value;
		}

		/**
		 * Gets the value of the dataInizioAttivitaAutonoma property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataInizioAttivitaAutonoma() {
			return dataInizioAttivitaAutonoma;
		}

		/**
		 * Sets the value of the dataInizioAttivitaAutonoma property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataInizioAttivitaAutonoma(String value) {
			this.dataInizioAttivitaAutonoma = value;
		}

		/**
		 * Gets the value of the dataInizioAttivitaSubord property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataInizioAttivitaSubord() {
			return dataInizioAttivitaSubord;
		}

		/**
		 * Sets the value of the dataInizioAttivitaSubord property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataInizioAttivitaSubord(String value) {
			this.dataInizioAttivitaSubord = value;
		}

		/**
		 * Gets the value of the dataInizioAttivitaParaSub property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataInizioAttivitaParaSub() {
			return dataInizioAttivitaParaSub;
		}

		/**
		 * Sets the value of the dataInizioAttivitaParaSub property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataInizioAttivitaParaSub(String value) {
			this.dataInizioAttivitaParaSub = value;
		}

		/**
		 * Gets the value of the dataInizioAttivitaAccess property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDataInizioAttivitaAccess() {
			return dataInizioAttivitaAccess;
		}

		/**
		 * Sets the value of the dataInizioAttivitaAccess property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setDataInizioAttivitaAccess(String value) {
			this.dataInizioAttivitaAccess = value;
		}

		/**
		 * Gets the value of the redditoLavoroAutonoma property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getRedditoLavoroAutonoma() {
			return redditoLavoroAutonoma;
		}

		/**
		 * Sets the value of the redditoLavoroAutonoma property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setRedditoLavoroAutonoma(BigDecimal value) {
			this.redditoLavoroAutonoma = value;
		}

		/**
		 * Gets the value of the redditoLavoroSubordinato property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getRedditoLavoroSubordinato() {
			return redditoLavoroSubordinato;
		}

		/**
		 * Sets the value of the redditoLavoroSubordinato property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setRedditoLavoroSubordinato(BigDecimal value) {
			this.redditoLavoroSubordinato = value;
		}

		/**
		 * Gets the value of the redditoLavoroParaSubord property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getRedditoLavoroParaSubord() {
			return redditoLavoroParaSubord;
		}

		/**
		 * Sets the value of the redditoLavoroParaSubord property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setRedditoLavoroParaSubord(BigDecimal value) {
			this.redditoLavoroParaSubord = value;
		}

		/**
		 * Gets the value of the redditoLavoroAccess property.
		 * 
		 * @return possible object is {@link BigDecimal }
		 * 
		 */
		public BigDecimal getRedditoLavoroAccess() {
			return redditoLavoroAccess;
		}

		/**
		 * Sets the value of the redditoLavoroAccess property.
		 * 
		 * @param value
		 *            allowed object is {@link BigDecimal }
		 * 
		 */
		public void setRedditoLavoroAccess(BigDecimal value) {
			this.redditoLavoroAccess = value;
		}

		/**
		 * Gets the value of the codiceComuneDomicilio property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodiceComuneDomicilio() {
			return codiceComuneDomicilio;
		}

		/**
		 * Sets the value of the codiceComuneDomicilio property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCodiceComuneDomicilio(String value) {
			this.codiceComuneDomicilio = value;
		}

		/**
		 * Gets the value of the comuneDomicilio property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getComuneDomicilio() {
			return comuneDomicilio;
		}

		/**
		 * Sets the value of the comuneDomicilio property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setComuneDomicilio(String value) {
			this.comuneDomicilio = value;
		}

		/**
		 * Gets the value of the provinciaDomicilio property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getProvinciaDomicilio() {
			return provinciaDomicilio;
		}

		/**
		 * Sets the value of the provinciaDomicilio property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setProvinciaDomicilio(String value) {
			this.provinciaDomicilio = value;
		}

		/**
		 * Gets the value of the indirizzoDomicilio property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getIndirizzoDomicilio() {
			return indirizzoDomicilio;
		}

		/**
		 * Sets the value of the indirizzoDomicilio property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setIndirizzoDomicilio(String value) {
			this.indirizzoDomicilio = value;
		}

		/**
		 * Gets the value of the capDomicilio property.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCapDomicilio() {
			return capDomicilio;
		}

		/**
		 * Sets the value of the capDomicilio property.
		 * 
		 * @param value
		 *            allowed object is {@link String }
		 * 
		 */
		public void setCapDomicilio(String value) {
			this.capDomicilio = value;
		}

	}

}