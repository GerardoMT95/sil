//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.30 at 02:59:33 PM CEST 
//


package it.eng.myportal.cliclavoro.candidatura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}idalbosil" minOccurs="0"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}idalbo" minOccurs="0"/>
 *         &lt;element name="notealbo" type="{http://servizi.lavoro.gov.it/candidatura}Stringa1000" minOccurs="0"/>
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
    "idalbosil",
    "idalbo",
    "notealbo"
})
@XmlRootElement(name = "Albi")
public class Albi {

    protected String idalbosil;
    protected String idalbo;
    protected String notealbo;

    /**
     * Gets the value of the idalbosil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdalbosil() {
        return idalbosil;
    }

    /**
     * Sets the value of the idalbosil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdalbosil(String value) {
        this.idalbosil = value;
    }

    /**
     * Gets the value of the idalbo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdalbo() {
        return idalbo;
    }

    /**
     * Sets the value of the idalbo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdalbo(String value) {
        this.idalbo = value;
    }

    /**
     * Gets the value of the notealbo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotealbo() {
        return notealbo;
    }

    /**
     * Sets the value of the notealbo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotealbo(String value) {
        this.notealbo = value;
    }

}
