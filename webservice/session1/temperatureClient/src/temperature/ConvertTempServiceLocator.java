/**
 * ConvertTempServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package temperature;

public class ConvertTempServiceLocator extends org.apache.axis.client.Service implements temperature.ConvertTempService {

    public ConvertTempServiceLocator() {
    }


    public ConvertTempServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConvertTempServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for convertTemp
    private java.lang.String convertTemp_address = "http://localhost:8080/temperature/services/convertTemp";

    public java.lang.String getconvertTempAddress() {
        return convertTemp_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String convertTempWSDDServiceName = "convertTemp";

    public java.lang.String getconvertTempWSDDServiceName() {
        return convertTempWSDDServiceName;
    }

    public void setconvertTempWSDDServiceName(java.lang.String name) {
        convertTempWSDDServiceName = name;
    }

    public temperature.ConvertTemp getconvertTemp() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(convertTemp_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getconvertTemp(endpoint);
    }

    public temperature.ConvertTemp getconvertTemp(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            temperature.ConvertTempSoapBindingStub _stub = new temperature.ConvertTempSoapBindingStub(portAddress, this);
            _stub.setPortName(getconvertTempWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setconvertTempEndpointAddress(java.lang.String address) {
        convertTemp_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (temperature.ConvertTemp.class.isAssignableFrom(serviceEndpointInterface)) {
                temperature.ConvertTempSoapBindingStub _stub = new temperature.ConvertTempSoapBindingStub(new java.net.URL(convertTemp_address), this);
                _stub.setPortName(getconvertTempWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("convertTemp".equals(inputPortName)) {
            return getconvertTemp();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://temperature", "convertTempService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://temperature", "convertTemp"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("convertTemp".equals(portName)) {
            setconvertTempEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
