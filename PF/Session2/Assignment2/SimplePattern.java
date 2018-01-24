package PF.Session2.Assignment2;

import PF.Session2.UserException.IllegalExpressionException;
/**
 * 
 * @author Anshul Agarwal
 * This class is used to print pattern
 * if n=5,
 * 12345
 *  1234
 *   123
 *    12
 *     1
 *     
 * Custom Exception is called if row number is greater than n  
 */
public class SimplePattern {
	
		public String[] printPattern(int n) throws IllegalExpressionException{
			String result[] = new String[n];
			for(int i=0;i<n;i++){
				System.out.println(spaces(i,n)+numbers(i, n));
				result[i] = spaces(i,n) + numbers(i, n);
			}
			return result;
		}
		/**
		 * 
		 * @param row
		 * @param n
		 * @return spaces as string according to pattern
		 * @throws IllegalExpressionException
		 */
		public String spaces(int row, int n) throws IllegalExpressionException{
			
			String space = "";
			
			if(row < n) {
				for(int i=0;i<row;i++) {
					space = space.concat(" ");
				}
			} else {
				throw new IllegalExpressionException("Illegal Expression");
			}
			return space;
		}
		 /**
		  * 
		  * @param row
		  * @param n
		  * @return number as string according to question
		  * @throws IllegalExpressionException
		  */
		public String numbers(int row,int n) throws IllegalExpressionException {
			
			String number = "";
			
			if(row < n) {
				for(int i=1;i <= n-row;i++) {
					number = number.concat(String.valueOf(i));
				}
			} else {
				throw new IllegalExpressionException("Illegal Expression");
			}
			return number;	
		}
}
