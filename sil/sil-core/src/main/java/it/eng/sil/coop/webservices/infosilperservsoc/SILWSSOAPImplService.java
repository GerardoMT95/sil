/**
 * SILWSSOAPImplService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.eng.sil.coop.webservices.infosilperservsoc;

public interface SILWSSOAPImplService extends javax.xml.rpc.Service {
	public java.lang.String getSILWSSOAPImplAddress();

	public it.eng.sil.coop.webservices.infosilperservsoc.SILWSSOAPImpl getSILWSSOAPImpl()
			throws javax.xml.rpc.ServiceException;

	public it.eng.sil.coop.webservices.infosilperservsoc.SILWSSOAPImpl getSILWSSOAPImpl(java.net.URL portAddress)
			throws javax.xml.rpc.ServiceException;
}
