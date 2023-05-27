//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.22 at 03:13:58 PM CET 
//

package it.gov.mlps.types;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for Profiling complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Profiling">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDSProfiling" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CodiceFiscale" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}CodiceFiscale"/>
 *         &lt;element name="Eta" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}Eta"/>
 *         &lt;element name="Genere" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}Genere"/>
 *         &lt;element name="Cittadinanza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DurataPresenzaInItalia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TitoloDiStudio" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ProvinciaDiResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegioneDiResidenza" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="HaLavoratoAlmenoUnaVolta" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CondizioneProfessionaleAnnoPrecedente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DurataDellaDisoccupazione" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}DurataDisoccupazione"/>
 *         &lt;element name="PosizioneUltimaOccupazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DurataRicercaLavoro" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}DurataRicercaLavoro"/>
 *         &lt;element name="AttualmenteIscrittoScuolaUniversitaOCorsoFormazione" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NumeroComponentiFamiglia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PresenzaFigliACarico" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PresenzaFigliMinoriACarico" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Probabilita" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DataInserimento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CondizioneOccupazionaleAnnoPrecedenteCalcolata" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DurataDisoccupazioneCalcolata" type="{http://mlps.gov.it/DataModels/InformationDelivery/ConferimentoDID/1.0}DurataDisoccupazione"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Profiling", propOrder = { "idsProfiling", "codiceFiscale", "eta", "genere", "cittadinanza",
		"durataPresenzaInItalia", "titoloDiStudio", "provinciaDiResidenza", "regioneDiResidenza",
		"haLavoratoAlmenoUnaVolta", "condizioneProfessionaleAnnoPrecedente", "durataDellaDisoccupazione",
		"posizioneUltimaOccupazione", "durataRicercaLavoro", "attualmenteIscrittoScuolaUniversitaOCorsoFormazione",
		"numeroComponentiFamiglia", "presenzaFigliACarico", "presenzaFigliMinoriACarico", "probabilita",
		"dataInserimento", "condizioneOccupazionaleAnnoPrecedenteCalcolata", "durataDisoccupazioneCalcolata" })
public class Profiling {

	@XmlElement(name = "IDSProfiling")
	protected long idsProfiling;
	@XmlElement(name = "CodiceFiscale", required = true)
	protected String codiceFiscale;
	@XmlElement(name = "Eta")
	protected int eta;
	@XmlElement(name = "Genere", required = true)
	protected Genere genere;
	@XmlElement(name = "Cittadinanza", required = true)
	protected String cittadinanza;
	@XmlElement(name = "DurataPresenzaInItalia", required = true, nillable = true)
	protected String durataPresenzaInItalia;
	@XmlElement(name = "TitoloDiStudio", required = true)
	protected String titoloDiStudio;
	@XmlElement(name = "ProvinciaDiResidenza", required = true)
	protected String provinciaDiResidenza;
	@XmlElement(name = "RegioneDiResidenza", required = true)
	protected String regioneDiResidenza;
	@XmlElement(name = "HaLavoratoAlmenoUnaVolta")
	protected boolean haLavoratoAlmenoUnaVolta;
	@XmlElement(name = "CondizioneProfessionaleAnnoPrecedente", required = true, nillable = true)
	protected String condizioneProfessionaleAnnoPrecedente;
	@XmlElement(name = "DurataDellaDisoccupazione", required = true, type = Integer.class, nillable = true)
	protected Integer durataDellaDisoccupazione;
	@XmlElement(name = "PosizioneUltimaOccupazione", required = true, nillable = true)
	protected String posizioneUltimaOccupazione;
	@XmlElement(name = "DurataRicercaLavoro")
	protected int durataRicercaLavoro;
	@XmlElement(name = "AttualmenteIscrittoScuolaUniversitaOCorsoFormazione", required = true)
	protected String attualmenteIscrittoScuolaUniversitaOCorsoFormazione;
	@XmlElement(name = "NumeroComponentiFamiglia")
	protected int numeroComponentiFamiglia;
	@XmlElement(name = "PresenzaFigliACarico")
	protected boolean presenzaFigliACarico;
	@XmlElement(name = "PresenzaFigliMinoriACarico", required = true, type = Boolean.class, nillable = true)
	protected Boolean presenzaFigliMinoriACarico;
	@XmlElement(name = "Probabilita", required = true)
	protected BigDecimal probabilita;
	@XmlElement(name = "DataInserimento", required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataInserimento;
	@XmlElement(name = "CondizioneOccupazionaleAnnoPrecedenteCalcolata", required = true, nillable = true)
	protected String condizioneOccupazionaleAnnoPrecedenteCalcolata;
	@XmlElement(name = "DurataDisoccupazioneCalcolata", required = true, type = Integer.class, nillable = true)
	protected Integer durataDisoccupazioneCalcolata;

	/**
	 * Gets the value of the idsProfiling property.
	 * 
	 */
	public long getIDSProfiling() {
		return idsProfiling;
	}

	/**
	 * Sets the value of the idsProfiling property.
	 * 
	 */
	public void setIDSProfiling(long value) {
		this.idsProfiling = value;
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
	 * Gets the value of the eta property.
	 * 
	 */
	public int getEta() {
		return eta;
	}

	/**
	 * Sets the value of the eta property.
	 * 
	 */
	public void setEta(int value) {
		this.eta = value;
	}

	/**
	 * Gets the value of the genere property.
	 * 
	 * @return possible object is {@link Genere }
	 * 
	 */
	public Genere getGenere() {
		return genere;
	}

	/**
	 * Sets the value of the genere property.
	 * 
	 * @param value
	 *            allowed object is {@link Genere }
	 * 
	 */
	public void setGenere(Genere value) {
		this.genere = value;
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
	 * Gets the value of the durataPresenzaInItalia property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDurataPresenzaInItalia() {
		return durataPresenzaInItalia;
	}

	/**
	 * Sets the value of the durataPresenzaInItalia property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDurataPresenzaInItalia(String value) {
		this.durataPresenzaInItalia = value;
	}

	/**
	 * Gets the value of the titoloDiStudio property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}

	/**
	 * Sets the value of the titoloDiStudio property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitoloDiStudio(String value) {
		this.titoloDiStudio = value;
	}

	/**
	 * Gets the value of the provinciaDiResidenza property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProvinciaDiResidenza() {
		return provinciaDiResidenza;
	}

	/**
	 * Sets the value of the provinciaDiResidenza property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProvinciaDiResidenza(String value) {
		this.provinciaDiResidenza = value;
	}

	/**
	 * Gets the value of the regioneDiResidenza property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegioneDiResidenza() {
		return regioneDiResidenza;
	}

	/**
	 * Sets the value of the regioneDiResidenza property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRegioneDiResidenza(String value) {
		this.regioneDiResidenza = value;
	}

	/**
	 * Gets the value of the haLavoratoAlmenoUnaVolta property.
	 * 
	 */
	public boolean isHaLavoratoAlmenoUnaVolta() {
		return haLavoratoAlmenoUnaVolta;
	}

	/**
	 * Sets the value of the haLavoratoAlmenoUnaVolta property.
	 * 
	 */
	public void setHaLavoratoAlmenoUnaVolta(boolean value) {
		this.haLavoratoAlmenoUnaVolta = value;
	}

	/**
	 * Gets the value of the condizioneProfessionaleAnnoPrecedente property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCondizioneProfessionaleAnnoPrecedente() {
		return condizioneProfessionaleAnnoPrecedente;
	}

	/**
	 * Sets the value of the condizioneProfessionaleAnnoPrecedente property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCondizioneProfessionaleAnnoPrecedente(String value) {
		this.condizioneProfessionaleAnnoPrecedente = value;
	}

	/**
	 * Gets the value of the durataDellaDisoccupazione property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getDurataDellaDisoccupazione() {
		return durataDellaDisoccupazione;
	}

	/**
	 * Sets the value of the durataDellaDisoccupazione property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setDurataDellaDisoccupazione(Integer value) {
		this.durataDellaDisoccupazione = value;
	}

	/**
	 * Gets the value of the posizioneUltimaOccupazione property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPosizioneUltimaOccupazione() {
		return posizioneUltimaOccupazione;
	}

	/**
	 * Sets the value of the posizioneUltimaOccupazione property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPosizioneUltimaOccupazione(String value) {
		this.posizioneUltimaOccupazione = value;
	}

	/**
	 * Gets the value of the durataRicercaLavoro property.
	 * 
	 */
	public int getDurataRicercaLavoro() {
		return durataRicercaLavoro;
	}

	/**
	 * Sets the value of the durataRicercaLavoro property.
	 * 
	 */
	public void setDurataRicercaLavoro(int value) {
		this.durataRicercaLavoro = value;
	}

	/**
	 * Gets the value of the attualmenteIscrittoScuolaUniversitaOCorsoFormazione property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAttualmenteIscrittoScuolaUniversitaOCorsoFormazione() {
		return attualmenteIscrittoScuolaUniversitaOCorsoFormazione;
	}

	/**
	 * Sets the value of the attualmenteIscrittoScuolaUniversitaOCorsoFormazione property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAttualmenteIscrittoScuolaUniversitaOCorsoFormazione(String value) {
		this.attualmenteIscrittoScuolaUniversitaOCorsoFormazione = value;
	}

	/**
	 * Gets the value of the numeroComponentiFamiglia property.
	 * 
	 */
	public int getNumeroComponentiFamiglia() {
		return numeroComponentiFamiglia;
	}

	/**
	 * Sets the value of the numeroComponentiFamiglia property.
	 * 
	 */
	public void setNumeroComponentiFamiglia(int value) {
		this.numeroComponentiFamiglia = value;
	}

	/**
	 * Gets the value of the presenzaFigliACarico property.
	 * 
	 */
	public boolean isPresenzaFigliACarico() {
		return presenzaFigliACarico;
	}

	/**
	 * Sets the value of the presenzaFigliACarico property.
	 * 
	 */
	public void setPresenzaFigliACarico(boolean value) {
		this.presenzaFigliACarico = value;
	}

	/**
	 * Gets the value of the presenzaFigliMinoriACarico property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isPresenzaFigliMinoriACarico() {
		return presenzaFigliMinoriACarico;
	}

	/**
	 * Sets the value of the presenzaFigliMinoriACarico property.
	 * 
	 * @param value
	 *            allowed object is {@link Boolean }
	 * 
	 */
	public void setPresenzaFigliMinoriACarico(Boolean value) {
		this.presenzaFigliMinoriACarico = value;
	}

	/**
	 * Gets the value of the probabilita property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getProbabilita() {
		return probabilita;
	}

	/**
	 * Sets the value of the probabilita property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setProbabilita(BigDecimal value) {
		this.probabilita = value;
	}

	/**
	 * Gets the value of the dataInserimento property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * Sets the value of the dataInserimento property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDataInserimento(XMLGregorianCalendar value) {
		this.dataInserimento = value;
	}

	/**
	 * Gets the value of the condizioneOccupazionaleAnnoPrecedenteCalcolata property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCondizioneOccupazionaleAnnoPrecedenteCalcolata() {
		return condizioneOccupazionaleAnnoPrecedenteCalcolata;
	}

	/**
	 * Sets the value of the condizioneOccupazionaleAnnoPrecedenteCalcolata property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCondizioneOccupazionaleAnnoPrecedenteCalcolata(String value) {
		this.condizioneOccupazionaleAnnoPrecedenteCalcolata = value;
	}

	/**
	 * Gets the value of the durataDisoccupazioneCalcolata property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getDurataDisoccupazioneCalcolata() {
		return durataDisoccupazioneCalcolata;
	}

	/**
	 * Sets the value of the durataDisoccupazioneCalcolata property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setDurataDisoccupazioneCalcolata(Integer value) {
		this.durataDisoccupazioneCalcolata = value;
	}

}
