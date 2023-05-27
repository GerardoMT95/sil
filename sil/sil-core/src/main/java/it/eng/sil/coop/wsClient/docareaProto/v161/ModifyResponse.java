/**
 * ModifyResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package it.eng.sil.coop.wsClient.docareaProto.v161;

public class ModifyResponse implements java.io.Serializable {
	private ModifyRet modifyResult;

	public ModifyResponse() {
	}

	public ModifyResponse(ModifyRet modifyResult) {
		this.modifyResult = modifyResult;
	}

	/**
	 * Gets the modifyResult value for this ModifyResponse.
	 * 
	 * @return modifyResult
	 */
	public ModifyRet getModifyResult() {
		return modifyResult;
	}

	/**
	 * Sets the modifyResult value for this ModifyResponse.
	 * 
	 * @param modifyResult
	 */
	public void setModifyResult(ModifyRet modifyResult) {
		this.modifyResult = modifyResult;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof ModifyResponse))
			return false;
		ModifyResponse other = (ModifyResponse) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ((this.modifyResult == null && other.getModifyResult() == null)
				|| (this.modifyResult != null && this.modifyResult.equals(other.getModifyResult())));
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
		if (getModifyResult() != null) {
			_hashCode += getModifyResult().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			ModifyResponse.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ModifyResponse"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("modifyResult");
		elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ModifyResult"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ModifyRet"));
		elemField.setMinOccurs(0);
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
