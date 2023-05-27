/**
 * PattoAccettatoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.eng.sil.coop.webservices.pattoonline;

public class PattoAccettatoType implements java.io.Serializable {
	private it.eng.sil.coop.webservices.pattoonline.PattoType patto;

	private it.eng.sil.coop.webservices.pattoonline.AccettazionePattoType accettazionePatto;

	public PattoAccettatoType() {
	}

	public PattoAccettatoType(it.eng.sil.coop.webservices.pattoonline.PattoType patto,
			it.eng.sil.coop.webservices.pattoonline.AccettazionePattoType accettazionePatto) {
		this.patto = patto;
		this.accettazionePatto = accettazionePatto;
	}

	/**
	 * Gets the patto value for this PattoAccettatoType.
	 * 
	 * @return patto
	 */
	public it.eng.sil.coop.webservices.pattoonline.PattoType getPatto() {
		return patto;
	}

	/**
	 * Sets the patto value for this PattoAccettatoType.
	 * 
	 * @param patto
	 */
	public void setPatto(it.eng.sil.coop.webservices.pattoonline.PattoType patto) {
		this.patto = patto;
	}

	/**
	 * Gets the accettazionePatto value for this PattoAccettatoType.
	 * 
	 * @return accettazionePatto
	 */
	public it.eng.sil.coop.webservices.pattoonline.AccettazionePattoType getAccettazionePatto() {
		return accettazionePatto;
	}

	/**
	 * Sets the accettazionePatto value for this PattoAccettatoType.
	 * 
	 * @param accettazionePatto
	 */
	public void setAccettazionePatto(it.eng.sil.coop.webservices.pattoonline.AccettazionePattoType accettazionePatto) {
		this.accettazionePatto = accettazionePatto;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PattoAccettatoType))
			return false;
		PattoAccettatoType other = (PattoAccettatoType) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.patto == null && other.getPatto() == null)
						|| (this.patto != null && this.patto.equals(other.getPatto())))
				&& ((this.accettazionePatto == null && other.getAccettazionePatto() == null)
						|| (this.accettazionePatto != null
								&& this.accettazionePatto.equals(other.getAccettazionePatto())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getPatto() != null) {
			_hashCode += getPatto().hashCode();
		}
		if (getAccettazionePatto() != null) {
			_hashCode += getAccettazionePatto().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PattoAccettatoType.class, true);

	static {
		typeDesc.setXmlType(
				new javax.xml.namespace.QName("http://pattoonline.webservices.coop.sil.eng.it/", "PattoAccettatoType"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("patto");
		elemField.setXmlName(new javax.xml.namespace.QName("http://pattoonline.webservices.coop.sil.eng.it/", "Patto"));
		elemField.setXmlType(
				new javax.xml.namespace.QName("http://pattoonline.webservices.coop.sil.eng.it/", "PattoType"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("accettazionePatto");
		elemField.setXmlName(
				new javax.xml.namespace.QName("http://pattoonline.webservices.coop.sil.eng.it/", "AccettazionePatto"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://pattoonline.webservices.coop.sil.eng.it/",
				"AccettazionePattoType"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
