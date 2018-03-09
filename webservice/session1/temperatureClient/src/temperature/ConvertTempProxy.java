package temperature;

public class ConvertTempProxy implements temperature.ConvertTemp {
  private String _endpoint = null;
  private temperature.ConvertTemp convertTemp = null;
  
  public ConvertTempProxy() {
    _initConvertTempProxy();
  }
  
  public ConvertTempProxy(String endpoint) {
    _endpoint = endpoint;
    _initConvertTempProxy();
  }
  
  private void _initConvertTempProxy() {
    try {
      convertTemp = (new temperature.ConvertTempServiceLocator()).getconvertTemp();
      if (convertTemp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)convertTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)convertTemp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (convertTemp != null)
      ((javax.xml.rpc.Stub)convertTemp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public temperature.ConvertTemp getConvertTemp() {
    if (convertTemp == null)
      _initConvertTempProxy();
    return convertTemp;
  }
  
  public float convertToCelsius(float farenheit) throws java.rmi.RemoteException{
    if (convertTemp == null)
      _initConvertTempProxy();
    return convertTemp.convertToCelsius(farenheit);
  }
  
  
}