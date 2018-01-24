package PF.Session1.Assignment5;                                         
/**
 * 
 * @author Anshul Agarwal
 * This class checks whether the array is sorted in ascending or descending or not sorted at all.
 * Assuming all same numbers in array is unsorted or duplicate numbers in between.
 */
public class CheckingSorting {
	/**
	 * 
	 * @param input is an array
	 * @return -> 1. If ascending order returns 1
	 * 			  2. If descending order returns 2
	 * 			  3. If unsorted returns 0
	 */
	int checkSort(int[] input){
		
		int result = 0; 	// assuming array is unsorted. 
		
		if((input.length-1) >= 0 && input[0] <= input[input.length -1]){	// compares last and first element
			result = assendingArray(input);		// if first number is less than last number then it can be in ascending order 
		}
		
		else if((input.length-1) >= 0 && input[0] > input[input.length -1]){
			result = descendingArray(input);	// if first number is larger than last number then it can be in descending order
		}
		
		else {
			return result;	//if first number and last number is equal then it is unsorted. 
		}
		return result;
	}
	
	/**
	 * 
	 * @param input is array of numbers
	 * @return integer 1
	 * checks ascending order
	 */
	public int assendingArray(int[] input){
		
		int counter=1;
		
		for(int rowCounter=0;rowCounter<input.length-1;rowCounter++){
			if(input[rowCounter] <= input[counter++]){
				continue;
			}
			else{
				return 0;
			}
		}
		return 1;
	}
	
	/**
	 * 
	 * @param input is array of numbers
	 * @return integer 2
	 * checks descending order
	 */
	public int descendingArray(int[] input){
		
		int counter=1;
		
		for(int rowCounter=0 ; rowCounter < input.length-1 ; rowCounter++){
			if(input[rowCounter] > input[counter++]){
				continue;
			}
			else{
				return 0;
			}
		}
		return 2;
	}
}
