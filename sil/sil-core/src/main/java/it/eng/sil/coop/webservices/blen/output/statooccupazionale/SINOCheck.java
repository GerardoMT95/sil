//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.27 at 02:51:16 PM CET 
//

package it.eng.sil.coop.webservices.blen.output.statooccupazionale;

import javax.xml.bind.annotation.XmlEnum;

/**
 * <p>
 * Java class for SINOCheck.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * <p>
 * 
 * <pre>
 * &lt;simpleType name="SINOCheck">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SI"/>
 *     &lt;enumeration value="NO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum SINOCheck {

NO, SI;

public String value() {
	return name();
}

public static SINOCheck fromValue(String v) {
	return valueOf(v);
}

}
