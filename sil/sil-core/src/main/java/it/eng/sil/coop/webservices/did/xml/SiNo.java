//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.06 at 11:52:34 AM CEST 
//

package it.eng.sil.coop.webservices.did.xml;

import javax.xml.bind.annotation.XmlEnum;

/**
 * <p>
 * Java class for Si-No.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="Si-No">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SiNo {

NO, SI;

public String value() {
	return name();
}

public static SiNo fromValue(String v) {
	return valueOf(v);
}

}