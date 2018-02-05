package PF.Session1.Assignment2;

import java.util.Arrays;
/**
 * 
 * @author Anshul Agarwal
 * This class is used to remove duplicates from an array
 */
public class RemoveDuplicateEntries {
	
	 	int result[]; // extra array which stores non duplicate element
	    int entries; // number of elements in input
	    int flag = 0;
	    int count = 0;
	    
	    /**
	     * 
	     * @param n is size of input
	     * This method initialize result array with MIN_VALUE and entries with n 
	     */
	    public RemoveDuplicateEntries(int n){
	        result = new int[n];
	        Arrays.fill(result, Integer.MIN_VALUE);
	        this.entries = n;
	    }
	    
	    /**
	     * 
	     * @param input is an array
	     * @return array which contains non duplicate entries
	     */
	    int[] removeDuplicate(int input[]){
	        for(int rowCounter = 0 ; rowCounter < entries ; rowCounter++){
	            flag=0;
	            for(int j=0;j<=count;j++){
	                if(input[rowCounter] == result[j]){    // check if input element is there in result array or not.
	                    flag = 1;
	                    break;     // if duplicate exists then break from inner loop.
	                }
	            }
	            if(flag == 0){
	            	result[count++] = input[rowCounter]; // if duplicate doesn't exists then insert the value in result array.
	            }
	        }
	        return Arrays.copyOfRange(result, 0, count);
	    }
}
