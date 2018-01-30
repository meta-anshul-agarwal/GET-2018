package PF.Session4.Assignment2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * This class is responsible for generating all the possible permutations
 *
 */
public class GeneratePermutation {
	
	// resulting list
	private List<String> result = new ArrayList<String>();
    
	/**
	 * 
	 * @param input is a string 
	 * @return List containing all the permutation of input string 
	 */
    public List<String> generatePermutations(String input){

        stringGenerator(input,0,input.length());
        
        // returning list
        return result;
    }
    /**
     * 
     * @param input
     * @param startIndex
     * @param size
     * @return String
     * this method generates string and add to the resultant list
     */
    String stringGenerator (String input , int startIndex, int size) {
    	// base condition
    	if(startIndex == size) {
    		
    		// adding permutation string into list
    		result.add(input);
    		
    		// returning string
    		return input;
    	}
    	
    	// loop that generates permutation  
		for(int j=startIndex;j<size;j++) {
			
			// swap of variable at position i and first index
			input =swap(input, j, startIndex);
			
			// calling recursive function for more combination
			stringGenerator(input, startIndex+1, size);
			
			// after backtracking for more solutions
			input =swap(input, j, startIndex); 
		}
		
		// returning resulting string
    	return input;
    }
   
    /**
     *   
     * @param input
     * @param i
     * @param j
     * @return string after swapping
     * 
     * This method is use for swapping the characters
     */
	String swap(String input, int i, int j){
       
		char charAt_i = input.charAt(i);
        char charAt_j = input.charAt(j); 
        input = input.substring(0, i) + charAt_j + input.substring(i + 1);
        input = input.substring(0, j) + charAt_i + input.substring(j + 1);
        return input;
    }
	
}