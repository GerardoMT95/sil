//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.04 at 02:47:55 PM CEST 
//


package it.eng.sil.module.ido.vacancy;

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
 *         &lt;element ref="{}nomereferente" minOccurs="0"/>
 *         &lt;element ref="{}cognomereferente" minOccurs="0"/>
 *         &lt;element ref="{}telefono" minOccurs="0"/>
 *         &lt;element ref="{}fax" minOccurs="0"/>
 *         &lt;element ref="{}email"/>
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
    "nomereferente",
    "cognomereferente",
    "telefono",
    "fax",
    "email"
})
@XmlRootElement(name = "DatiContattoAlternativo")
public class DatiContattoAlternativo {

    protected String nomereferente;
    protected String cognomereferente;
    protected String telefono;
    protected String fax;
    @XmlElement(required = true)
    protected String email;

    /**
     * Gets the value of the nomereferente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomereferente() {
        return nomereferente;
    }

    /**
     * Sets the value of the nomereferente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomereferente(String value) {
        this.nomereferente = value;
    }

    /**
     * Gets the value of the cognomereferente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognomereferente() {
        return cognomereferente;
    }

    /**
     * Sets the value of the cognomereferente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCognomereferente(String value) {
        this.cognomereferente = value;
    }

    /**
     * Gets the value of the telefono property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets the value of the telefono property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
