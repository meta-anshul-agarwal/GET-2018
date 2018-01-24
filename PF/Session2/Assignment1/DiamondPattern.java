package PF.Session2.Assignment1;

import PF.Session2.UserException.IllegalExpressionException;
/**
 * 
 * @author Anshul Agarwal
 * This class is used to print pattern
 * if n=3,
 *   1
 *  121
 * 12321
 *  121
 *   1  
 *  
 * Custom Exception is called if row number is greater than 2*n  
 */
public class DiamondPattern {
	public static void main(String[]args) throws IllegalExpressionException {
			
			System.out.println(spaces(0,7)+numbers(0, 7));
			System.out.println(spaces(1,7)+numbers(1, 7));
			System.out.println(spaces(2,7)+numbers(2, 7));
			System.out.println(spaces(3,7)+numbers(3, 7));
			System.out.println(spaces(4,7)+numbers(4, 7));
			System.out.println(spaces(7,7)+numbers(7, 7));
			System.out.println(spaces(6,7)+numbers(6, 7));
			System.out.println(spaces(7,7)+numbers(7, 7));
			System.out.println(spaces(8,7)+numbers(8, 7));
			System.out.println(spaces(9,7)+numbers(9, 7));
			System.out.println(spaces(10,7)+numbers(10, 7));
			System.out.println(spaces(11,7)+numbers(11, 7));
			System.out.println(spaces(12,7)+numbers(12, 7));
			System.out.println(spaces(13,7)+numbers(13, 7));
			
		}
	
		/**
		 * 
		 * @param row
		 * @param n
		 * @return spaces as string according to pattern
		 * @throws IllegalExpressionException
		 */
		public static String spaces(int row, int n) throws IllegalExpressionException {
			
			int i;
			String space = "";
			
			if(row < 2*n) {
				row = row < n ? n-row-1 : row-n+1;
				if(row <= n) {
					for(i=0 ;i<row;i++) {
						space = space.concat(" ");
					}
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
		int j; 
		
		if(row < 2*n) {
			row = row < n ? row : 2*n - row - 2 ;
			if(row < n) {
					for(j = 0; j <= row ; j++) {
						number = number.concat(String.valueOf(j+1));
				}
			}
			if(row < n) {
					for(j = 0; j < row ; j++) {
						number = number.concat(String.valueOf(row-j));
				}
			}
		} else {
			
			throw new IllegalExpressionException("Illegal Expression");
		}
		return number;	
	}
}
