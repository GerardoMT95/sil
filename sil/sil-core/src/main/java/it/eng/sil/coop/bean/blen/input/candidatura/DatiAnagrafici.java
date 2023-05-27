//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.18 at 03:56:22 PM CET 
//

package it.eng.sil.coop.bean.blen.input.candidatura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for DatiAnagrafici element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="DatiAnagrafici">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}codicefiscale"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}cognome"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}nome"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}sesso"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}datanascita"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}idcomune"/>
 *           &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}idcittadinanza"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "codicefiscale", "cognome", "nome", "sesso", "datanascita", "idcomune",
		"idcittadinanza" })
@XmlRootElement(name = "DatiAnagrafici")
public class DatiAnagrafici {

	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected String codicefiscale;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected String cognome;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected String nome;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected Sessocheck sesso;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected XMLGregorianCalendar datanascita;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected String idcomune;
	@XmlElement(namespace = "http://servizi.lavoro.gov.it/candidatura", required = true)
	protected String idcittadinanza;

	/**
	 * Gets the value of the codicefiscale property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodicefiscale() {
		return codicefiscale;
	}

	/**
	 * Sets the value of the codicefiscale property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodicefiscale(String value) {
		this.codicefiscale = value;
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
	 * Gets the value of the sesso property.
	 * 
	 * @return possible object is {@link Sessocheck }
	 * 
	 */
	public Sessocheck getSesso() {
		return sesso;
	}

	/**
	 * Sets the value of the sesso property.
	 * 
	 * @param value
	 *            allowed object is {@link Sessocheck }
	 * 
	 */
	public void setSesso(Sessocheck value) {
		this.sesso = value;
	}

	/**
	 * Gets the value of the datanascita property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDatanascita() {
		return datanascita;
	}

	/**
	 * Sets the value of the datanascita property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDatanascita(XMLGregorianCalendar value) {
		this.datanascita = value;
	}

	/**
	 * Gets the value of the idcomune property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdcomune() {
		return idcomune;
	}

	/**
	 * Sets the value of the idcomune property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdcomune(String value) {
		this.idcomune = value;
	}

	/**
	 * Gets the value of the idcittadinanza property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdcittadinanza() {
		return idcittadinanza;
	}

	/**
	 * Sets the value of the idcittadinanza property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdcittadinanza(String value) {
		this.idcittadinanza = value;
	}

}
