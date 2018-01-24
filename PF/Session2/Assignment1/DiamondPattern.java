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

	public String[] printPattern(int n) throws IllegalExpressionException{
		String result[] = new String[2*n-1];
		for(int i=0;i<2*n-1;i++){
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
		public String spaces(int row, int n) throws IllegalExpressionException {
			
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
		public String numbers(int row,int n) throws IllegalExpressionException {
		
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
