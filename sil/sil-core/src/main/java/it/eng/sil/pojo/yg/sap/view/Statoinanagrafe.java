//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.09.04 at 03:01:56 PM CEST 
//

package it.eng.sil.pojo.yg.sap.view;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}codstatooccupazionale" minOccurs="0"/>
 *         &lt;element ref="{}codstatus" minOccurs="0"/>
 *         &lt;element ref="{}categoria297" minOccurs="0"/>
 *         &lt;element ref="{}anzianita" minOccurs="0"/>
 *         &lt;element name="indiceprofiling" type="{}IndiceProfiling" minOccurs="0"/>
 *         &lt;element ref="{}dataevento" minOccurs="0"/>
 *         &lt;element ref="{}disponibilita" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "codstatooccupazionale", "codstatus", "categoria297", "anzianita", "indiceprofiling",
		"dataevento", "disponibilita" })
@XmlRootElement(name = "statoinanagrafe")
public class Statoinanagrafe {

	protected String codstatooccupazionale;
	protected String codstatus;
	protected String categoria297;
	protected String anzianita;
	protected BigDecimal indiceprofiling;
	protected XMLGregorianCalendar dataevento;
	protected XMLGregorianCalendar disponibilita;

	/**
	 * Gets the value of the codstatooccupazionale property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodstatooccupazionale() {
		return codstatooccupazionale;
	}

	/**
	 * Sets the value of the codstatooccupazionale property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodstatooccupazionale(String value) {
		this.codstatooccupazionale = value;
	}

	/**
	 * Gets the value of the codstatus property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCodstatus() {
		return codstatus;
	}

	/**
	 * Sets the value of the codstatus property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCodstatus(String value) {
		this.codstatus = value;
	}

	/**
	 * Gets the value of the categoria297 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCategoria297() {
		return categoria297;
	}

	/**
	 * Sets the value of the categoria297 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCategoria297(String value) {
		this.categoria297 = value;
	}

	/**
	 * Gets the value of the anzianita property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAnzianita() {
		return anzianita;
	}

	/**
	 * Sets the value of the anzianita property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setAnzianita(String value) {
		this.anzianita = value;
	}

	/**
	 * Gets the value of the indiceprofiling property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getIndiceprofiling() {
		return indiceprofiling;
	}

	/**
	 * Sets the value of the indiceprofiling property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setIndiceprofiling(BigDecimal value) {
		this.indiceprofiling = value;
	}

	/**
	 * Gets the value of the dataevento property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDataevento() {
		return dataevento;
	}

	/**
	 * Sets the value of the dataevento property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDataevento(XMLGregorianCalendar value) {
		this.dataevento = value;
	}

	/**
	 * Gets the value of the disponibilita property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDisponibilita() {
		return disponibilita;
	}

	/**
	 * Sets the value of the disponibilita property.
	 * 
	 * @param value
	 *            allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDisponibilita(XMLGregorianCalendar value) {
		this.disponibilita = value;
	}

}