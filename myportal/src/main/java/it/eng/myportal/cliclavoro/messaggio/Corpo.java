//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.31 at 12:20:27 PM CEST 
//


package it.eng.myportal.cliclavoro.messaggio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/messaggio}testomessaggio"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/messaggio}contattopositivo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "testomessaggio",
    "contattopositivo"
})
@XmlRootElement(name = "Corpo")
public class Corpo {

    @XmlElement(required = true)
    protected String testomessaggio;
    protected SiNo contattopositivo;

    /**
     * Gets the value of the testomessaggio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestomessaggio() {
        return testomessaggio;
    }

    /**
     * Sets the value of the testomessaggio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestomessaggio(String value) {
        this.testomessaggio = value;
    }

    /**
     * Gets the value of the contattopositivo property.
     * 
     * @return
     *     possible object is
     *     {@link SiNo }
     *     
     */
    public SiNo getContattopositivo() {
        return contattopositivo;
    }

    /**
     * Sets the value of the contattopositivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SiNo }
     *     
     */
    public void setContattopositivo(SiNo value) {
        this.contattopositivo = value;
    }

}