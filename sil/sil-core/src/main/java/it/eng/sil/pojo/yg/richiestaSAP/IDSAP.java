//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.04.04 at 10:17:40 AM CEST 
//

package it.eng.sil.pojo.yg.richiestaSAP;

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
 *         &lt;element name="IdentificativoSap" type="{}IdentificativoSap"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "identificativoSap" })
@XmlRootElement(name = "IDSAP")
public class IDSAP {

	@XmlElement(name = "IdentificativoSap", required = true)
	protected String identificativoSap;

	/**
	 * Gets the value of the identificativoSap property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdentificativoSap() {
		return identificativoSap;
	}

	/**
	 * Sets the value of the identificativoSap property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdentificativoSap(String value) {
		this.identificativoSap = value;
	}

}
