/**
 * NuovoRedditoAttivazione_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.eng.sil.coop.webservices.nuovoRedditoAttivazione;

public class NuovoRedditoAttivazione_ServiceLocator extends org.apache.axis.client.Service
		implements it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_Service {

	public NuovoRedditoAttivazione_ServiceLocator() {
	}

	public NuovoRedditoAttivazione_ServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public NuovoRedditoAttivazione_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for NuovoRedditoAttivazione
	private java.lang.String NuovoRedditoAttivazione_address = "";

	public java.lang.String getNuovoRedditoAttivazioneAddress() {
		return NuovoRedditoAttivazione_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String NuovoRedditoAttivazioneWSDDServiceName = "NuovoRedditoAttivazione";

	public java.lang.String getNuovoRedditoAttivazioneWSDDServiceName() {
		return NuovoRedditoAttivazioneWSDDServiceName;
	}

	public void setNuovoRedditoAttivazioneWSDDServiceName(java.lang.String name) {
		NuovoRedditoAttivazioneWSDDServiceName = name;
	}

	public it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_PortType getNuovoRedditoAttivazione()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(NuovoRedditoAttivazione_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getNuovoRedditoAttivazione(endpoint);
	}

	public it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_PortType getNuovoRedditoAttivazione(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_BindingStub _stub = new it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_BindingStub(
					portAddress, this);
			_stub.setPortName(getNuovoRedditoAttivazioneWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setNuovoRedditoAttivazioneEndpointAddress(java.lang.String address) {
		NuovoRedditoAttivazione_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no port for the given interface, then
	 * ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_PortType.class
					.isAssignableFrom(serviceEndpointInterface)) {
				it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_BindingStub _stub = new it.eng.sil.coop.webservices.nuovoRedditoAttivazione.NuovoRedditoAttivazione_BindingStub(
						new java.net.URL(NuovoRedditoAttivazione_address), this);
				_stub.setPortName(getNuovoRedditoAttivazioneWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has no port for the given interface, then
	 * ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("NuovoRedditoAttivazione".equals(inputPortName)) {
			return getNuovoRedditoAttivazione();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://ws.inps.it/", "NuovoRedditoAttivazione");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://ws.inps.it/", "NuovoRedditoAttivazione"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {

		if ("NuovoRedditoAttivazione".equals(portName)) {
			setNuovoRedditoAttivazioneEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address)
			throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
