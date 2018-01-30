package PF.Session4.Assignment3;

public class Nqueen {
	
	/**
	 * 
	 * @param input is 2d array with all values 0
	 * @return resultant 2d array
	 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
	 */
	public int[][] nQueen_solution(int[][] input) {
		
		// calling nQueen for solution
		nQueen(input , 0 , input.length);
		
		// returning solution in 2D array 
		return input;
	}
	
	public boolean nQueen(int[][] matrix , int startRow, int dimensionOfMatrix) {
		
		// initialization of returning variable
		boolean check = false;
		
		// loop variable
		int i=0;
		
		// Base condition , if all the rows finished
		if(startRow >= dimensionOfMatrix){
			return true;
		}
		
		for( i = 0 ; i < dimensionOfMatrix  ; i++) {
			
			// checks if queen is safe at that position or not 
			if( safe( matrix, i, dimensionOfMatrix, startRow)) {
				
				// putting value 1 at safe position
				matrix[startRow][i] = 1;
				
				// now calling nQueen for next call(recursive call)
				check = nQueen(matrix, startRow+1, dimensionOfMatrix);
				
				// if returns true from base condition then return value of check
				if(check) {
					return check;
				}
				
				// if check is false then put value 0 
				matrix[startRow][i] = 0;
			}
		}
		
		// returns value of check
		return check;
	}
	
	/**
	 * 
	 * @param matrix
	 * @param column
	 * @param dimensionOfMatrix
	 * @param startRow
	 * @return true if queen is safe otherwise false
	 */
	boolean safe(int[][] matrix , int column, int dimensionOfMatrix, int startRow){
		
		int k=1; // variable for going upward
		
		for(int i = startRow-1 ; i >= 0 ; i--) {
			
			// checks left diagonal if there is any 1 exists
			if((column-k>=0)&&(matrix[i][column-k]==1)) {
				return false;
			}
			
			// checks right diagonal if there is any 1 exists
			if((column+k<dimensionOfMatrix)&&((matrix[i][column+k]==1))) {
				return false;
			}
			
			// checks vertically upward
			if(matrix[i][column] == 1) {
				return false;
			}
			
			// increment for going upward 
			k++;
		}
		
		return true;
	}

}
