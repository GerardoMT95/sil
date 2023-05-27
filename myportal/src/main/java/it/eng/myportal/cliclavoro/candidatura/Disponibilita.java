//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.30 at 02:59:33 PM CEST 
//


package it.eng.myportal.cliclavoro.candidatura;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}turno" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}Territorio" minOccurs="0"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}Mobilita" minOccurs="0"/>
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
    "turno",
    "territorio",
    "mobilita"
})
@XmlRootElement(name = "Disponibilita")
public class Disponibilita {

    protected List<String> turno;
    @XmlElement(name = "Territorio")
    protected Territorio territorio;
    @XmlElement(name = "Mobilita")
    protected Mobilita mobilita;

    /**
     * Gets the value of the turno property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the turno property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTurno().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTurno() {
        if (turno == null) {
            turno = new ArrayList<String>();
        }
        return this.turno;
    }

    /**
     * Gets the value of the territorio property.
     * 
     * @return
     *     possible object is
     *     {@link Territorio }
     *     
     */
    public Territorio getTerritorio() {
        return territorio;
    }

    /**
     * Sets the value of the territorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Territorio }
     *     
     */
    public void setTerritorio(Territorio value) {
        this.territorio = value;
    }

    /**
     * Gets the value of the mobilita property.
     * 
     * @return
     *     possible object is
     *     {@link Mobilita }
     *     
     */
    public Mobilita getMobilita() {
        return mobilita;
    }

    /**
     * Sets the value of the mobilita property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mobilita }
     *     
     */
    public void setMobilita(Mobilita value) {
        this.mobilita = value;
    }

}