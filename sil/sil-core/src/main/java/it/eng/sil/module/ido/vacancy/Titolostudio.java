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
 *         &lt;element ref="{}codtitolostudio"/>
 *         &lt;element ref="{}descrizionestudio" minOccurs="0"/>
 *         &lt;element ref="{}specifica" minOccurs="0"/>
 *         &lt;element name="conseguito" type="{}Y-N" minOccurs="0"/>
 *         &lt;element name="titoloindisp" type="{}Y-N" minOccurs="0"/>
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
    "codtitolostudio",
    "descrizionestudio",
    "specifica",
    "conseguito",
    "titoloindisp"
})
@XmlRootElement(name = "titolostudio")
public class Titolostudio {

    @XmlElement(required = true)
    protected String codtitolostudio;
    protected String descrizionestudio;
    protected String specifica;
    protected YN conseguito;
    protected YN titoloindisp;

    /**
     * Gets the value of the codtitolostudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodtitolostudio() {
        return codtitolostudio;
    }

    /**
     * Sets the value of the codtitolostudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodtitolostudio(String value) {
        this.codtitolostudio = value;
    }

    /**
     * Gets the value of the descrizionestudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizionestudio() {
        return descrizionestudio;
    }

    /**
     * Sets the value of the descrizionestudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizionestudio(String value) {
        this.descrizionestudio = value;
    }

    /**
     * Gets the value of the specifica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecifica() {
        return specifica;
    }

    /**
     * Sets the value of the specifica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecifica(String value) {
        this.specifica = value;
    }

    /**
     * Gets the value of the conseguito property.
     * 
     * @return
     *     possible object is
     *     {@link YN }
     *     
     */
    public YN getConseguito() {
        return conseguito;
    }

    /**
     * Sets the value of the conseguito property.
     * 
     * @param value
     *     allowed object is
     *     {@link YN }
     *     
     */
    public void setConseguito(YN value) {
        this.conseguito = value;
    }

    /**
     * Gets the value of the titoloindisp property.
     * 
     * @return
     *     possible object is
     *     {@link YN }
     *     
     */
    public YN getTitoloindisp() {
        return titoloindisp;
    }

    /**
     * Sets the value of the titoloindisp property.
     * 
     * @param value
     *     allowed object is
     *     {@link YN }
     *     
     */
    public void setTitoloindisp(YN value) {
        this.titoloindisp = value;
    }

}
