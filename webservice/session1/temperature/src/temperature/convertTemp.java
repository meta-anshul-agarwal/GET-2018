/*
 * This file contains the class convertTemp.
 */
package temperature;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * This class contains a function to convert temperature units
 * @author Amit Sharma
 *
 */
@WebService
public class convertTemp {

	/**
	 * This function takes a input parameter whic is the temperature in farenhiet
	 * and returns the celsius equivalent temperature.
	 * @param farenheit
	 * @return celsius equivalent temperature
	 */
	@WebMethod
	public float convertToCelsius(float farenheit){
		return ( ( farenheit - 32) * 5 ) / 9;
	}
}