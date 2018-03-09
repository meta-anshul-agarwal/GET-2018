package temperature;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
 * a client class to test the web service convertTemp
 * @author Amit Sharma
 *
 */
public class test {
	
	public static void main(String[] args) throws RemoteException, ServiceException{
		//to obtain the service instance of required class
		ConvertTempServiceLocator srvLoc = new ConvertTempServiceLocator();
		System.out.println(srvLoc.getconvertTemp().convertToCelsius(4f));
	}
}
