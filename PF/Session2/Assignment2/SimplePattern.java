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
	public static void main(String[]args) throws IllegalExpressionException {
			
			System.out.println(spaces(0,5)+numbers(0, 5));
			System.out.println(spaces(1,5)+numbers(1, 5));
			System.out.println(spaces(2,5)+numbers(2, 5));
			System.out.println(spaces(3,5)+numbers(3, 5));
			System.out.println(spaces(4,5)+numbers(4, 5));
			
		}
	
		/**
		 * 
		 * @param row
		 * @param n
		 * @return spaces as string according to pattern
		 * @throws IllegalExpressionException
		 */
		public static String spaces(int row, int n) throws IllegalExpressionException{
			
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
		public static String numbers(int row,int n) throws IllegalExpressionException {
			
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
