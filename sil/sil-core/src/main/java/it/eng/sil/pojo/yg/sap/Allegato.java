//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.13 at 11:45:47 AM CEST 
//

package it.eng.sil.pojo.yg.sap;

import java.util.ArrayList;
import java.util.List;

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
 *         &lt;element ref="{}titolistudio_lst" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}formazioneprofessionale_lst" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}linguestraniere_lst" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}conoscenzeinformatiche_lst" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}altreinformazioni_lst" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "titolistudioLst", "formazioneprofessionaleLst", "linguestraniereLst",
		"conoscenzeinformaticheLst", "altreinformazioniLst" })
@XmlRootElement(name = "allegato")
public class Allegato {

	@XmlElement(name = "titolistudio_lst")
	protected List<TitolistudioLst> titolistudioLst;
	@XmlElement(name = "formazioneprofessionale_lst")
	protected List<FormazioneprofessionaleLst> formazioneprofessionaleLst;
	@XmlElement(name = "linguestraniere_lst")
	protected List<LinguestraniereLst> linguestraniereLst;
	@XmlElement(name = "conoscenzeinformatiche_lst")
	protected List<ConoscenzeinformaticheLst> conoscenzeinformaticheLst;
	@XmlElement(name = "altreinformazioni_lst")
	protected List<AltreinformazioniLst> altreinformazioniLst;

	/**
	 * Gets the value of the titolistudioLst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the titolistudioLst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getTitolistudioLst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link TitolistudioLst }
	 * 
	 * 
	 */
	public List<TitolistudioLst> getTitolistudioLst() {
		if (titolistudioLst == null) {
			titolistudioLst = new ArrayList<TitolistudioLst>();
		}
		return this.titolistudioLst;
	}

	/**
	 * Gets the value of the formazioneprofessionaleLst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the formazioneprofessionaleLst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getFormazioneprofessionaleLst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link FormazioneprofessionaleLst }
	 * 
	 * 
	 */
	public List<FormazioneprofessionaleLst> getFormazioneprofessionaleLst() {
		if (formazioneprofessionaleLst == null) {
			formazioneprofessionaleLst = new ArrayList<FormazioneprofessionaleLst>();
		}
		return this.formazioneprofessionaleLst;
	}

	/**
	 * Gets the value of the linguestraniereLst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the linguestraniereLst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLinguestraniereLst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link LinguestraniereLst }
	 * 
	 * 
	 */
	public List<LinguestraniereLst> getLinguestraniereLst() {
		if (linguestraniereLst == null) {
			linguestraniereLst = new ArrayList<LinguestraniereLst>();
		}
		return this.linguestraniereLst;
	}

	/**
	 * Gets the value of the conoscenzeinformaticheLst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the conoscenzeinformaticheLst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getConoscenzeinformaticheLst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link ConoscenzeinformaticheLst }
	 * 
	 * 
	 */
	public List<ConoscenzeinformaticheLst> getConoscenzeinformaticheLst() {
		if (conoscenzeinformaticheLst == null) {
			conoscenzeinformaticheLst = new ArrayList<ConoscenzeinformaticheLst>();
		}
		return this.conoscenzeinformaticheLst;
	}

	/**
	 * Gets the value of the altreinformazioniLst property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
	 * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
	 * the altreinformazioniLst property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAltreinformazioniLst().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link AltreinformazioniLst }
	 * 
	 * 
	 */
	public List<AltreinformazioniLst> getAltreinformazioniLst() {
		if (altreinformazioniLst == null) {
			altreinformazioniLst = new ArrayList<AltreinformazioniLst>();
		}
		return this.altreinformazioniLst;
	}

}
