/**
 * Risposta_invioSAP_TypeEsito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.gov.lavoro.servizi.servizicoapSap.types;

public class Risposta_invioSAP_TypeEsito implements java.io.Serializable {
	private java.lang.String _value_;
	private static java.util.HashMap _table_ = new java.util.HashMap();

	// Constructor
	protected Risposta_invioSAP_TypeEsito(java.lang.String value) {
		_value_ = value;
		_table_.put(_value_, this);
	}

	public static final java.lang.String _OK = "OK";
	public static final java.lang.String _KO = "KO";
	public static final java.lang.String _X001 = "X001";
	public static final Risposta_invioSAP_TypeEsito OK = new Risposta_invioSAP_TypeEsito(_OK);
	public static final Risposta_invioSAP_TypeEsito KO = new Risposta_invioSAP_TypeEsito(_KO);
	public static final Risposta_invioSAP_TypeEsito X001 = new Risposta_invioSAP_TypeEsito(_X001);

	public java.lang.String getValue() {
		return _value_;
	}

	public static Risposta_invioSAP_TypeEsito fromValue(java.lang.String value)
			throws java.lang.IllegalArgumentException {
		Risposta_invioSAP_TypeEsito enumeration = (Risposta_invioSAP_TypeEsito) _table_.get(value);
		if (enumeration == null)
			throw new java.lang.IllegalArgumentException();
		return enumeration;
	}

	public static Risposta_invioSAP_TypeEsito fromString(java.lang.String value)
			throws java.lang.IllegalArgumentException {
		return fromValue(value);
	}

	public boolean equals(java.lang.Object obj) {
		return (obj == this);
	}

	public int hashCode() {
		return toString().hashCode();
	}

	public java.lang.String toString() {
		return _value_;
	}

	public java.lang.Object readResolve() throws java.io.ObjectStreamException {
		return fromValue(_value_);
	}

	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.EnumSerializer(_javaType, _xmlType);
	}

	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.EnumDeserializer(_javaType, _xmlType);
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			Risposta_invioSAP_TypeEsito.class);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://servizi.lavoro.gov.it/servizicoap/types",
				">risposta_invioSAP_Type>Esito"));
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

}