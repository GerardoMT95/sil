//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.13 at 11:45:47 AM CEST 
//

package it.eng.sil.pojo.yg.sap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}telefono" minOccurs="0"/>
 *         &lt;element ref="{}cellulare" minOccurs="0"/>
 *         &lt;element ref="{}fax" minOccurs="0"/>
 *         &lt;element ref="{}email" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "telefono", "cellulare", "fax", "email" })
@XmlRootElement(name = "recapiti")
public class Recapiti {

	protected String telefono;
	protected String cellulare;
	protected String fax;
	protected String email;

	/**
	 * Gets the value of the telefono property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the value of the telefono property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTelefono(String value) {
		this.telefono = value;
	}

	/**
	 * Gets the value of the cellulare property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCellulare() {
		return cellulare;
	}

	/**
	 * Sets the value of the cellulare property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCellulare(String value) {
		this.cellulare = value;
	}

	/**
	 * Gets the value of the fax property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the value of the fax property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFax(String value) {
		this.fax = value;
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

}
