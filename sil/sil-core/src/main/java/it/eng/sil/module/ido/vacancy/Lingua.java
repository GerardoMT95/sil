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
 *         &lt;element ref="{}codlingua"/>
 *         &lt;element ref="{}codlivelloletto" minOccurs="0"/>
 *         &lt;element ref="{}codlivelloscritto" minOccurs="0"/>
 *         &lt;element ref="{}codlivelloparlato" minOccurs="0"/>
 *         &lt;element name="linguaindisp" type="{}Y-N" minOccurs="0"/>
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
    "codlingua",
    "codlivelloletto",
    "codlivelloscritto",
    "codlivelloparlato",
    "linguaindisp"
})
@XmlRootElement(name = "Lingua")
public class Lingua {

    @XmlElement(required = true)
    protected String codlingua;
    protected String codlivelloletto;
    protected String codlivelloscritto;
    protected String codlivelloparlato;
    protected YN linguaindisp;

    /**
     * Gets the value of the codlingua property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodlingua() {
        return codlingua;
    }

    /**
     * Sets the value of the codlingua property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodlingua(String value) {
        this.codlingua = value;
    }

    /**
     * Gets the value of the codlivelloletto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodlivelloletto() {
        return codlivelloletto;
    }

    /**
     * Sets the value of the codlivelloletto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodlivelloletto(String value) {
        this.codlivelloletto = value;
    }

    /**
     * Gets the value of the codlivelloscritto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodlivelloscritto() {
        return codlivelloscritto;
    }

    /**
     * Sets the value of the codlivelloscritto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodlivelloscritto(String value) {
        this.codlivelloscritto = value;
    }

    /**
     * Gets the value of the codlivelloparlato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodlivelloparlato() {
        return codlivelloparlato;
    }

    /**
     * Sets the value of the codlivelloparlato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodlivelloparlato(String value) {
        this.codlivelloparlato = value;
    }

    /**
     * Gets the value of the linguaindisp property.
     * 
     * @return
     *     possible object is
     *     {@link YN }
     *     
     */
    public YN getLinguaindisp() {
        return linguaindisp;
    }

    /**
     * Sets the value of the linguaindisp property.
     * 
     * @param value
     *     allowed object is
     *     {@link YN }
     *     
     */
    public void setLinguaindisp(YN value) {
        this.linguaindisp = value;
    }

}