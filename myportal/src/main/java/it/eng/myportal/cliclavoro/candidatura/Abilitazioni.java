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
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}Albi" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}Patenti" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://servizi.lavoro.gov.it/candidatura}Patentini" maxOccurs="unbounded" minOccurs="0"/>
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
    "albi",
    "patenti",
    "patentini"
})
@XmlRootElement(name = "Abilitazioni")
public class Abilitazioni {

    @XmlElement(name = "Albi")
    protected List<Albi> albi;
    @XmlElement(name = "Patenti")
    protected List<Patenti> patenti;
    @XmlElement(name = "Patentini")
    protected List<Patentini> patentini;

    /**
     * Gets the value of the albi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the albi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlbi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Albi }
     * 
     * 
     */
    public List<Albi> getAlbi() {
        if (albi == null) {
            albi = new ArrayList<Albi>();
        }
        return this.albi;
    }

    /**
     * Gets the value of the patenti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the patenti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPatenti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Patenti }
     * 
     * 
     */
    public List<Patenti> getPatenti() {
        if (patenti == null) {
            patenti = new ArrayList<Patenti>();
        }
        return this.patenti;
    }

    /**
     * Gets the value of the patentini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the patentini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPatentini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Patentini }
     * 
     * 
     */
    public List<Patentini> getPatentini() {
        if (patentini == null) {
            patentini = new ArrayList<Patentini>();
        }
        return this.patentini;
    }

}
