package PF.Session3.Assignment3;

/**
 * 
 * @author Anshul Agarwal
 * This class contains quick sort method using recursive
 *
 */
public class QuickSort {
	/**
	 * 
	 * @param input is array
	 * @param start is starting index of input array
	 * @param end is ending index of input array
	 * @return sorted array
	 */
    public int[] sort(int[] input,int start,int end){
    	
        int i = start - 1; // initializing i which is index of swapping element 
        int j=0; // loop variable
        int pivot = end; // assuming pivot is end index
        
        // Base condition, if array contains any element or not
        if(start >= end){
            return input;
        }
        
        // loop starts with starting index and end with ending index
        for(j=start;j<end - start;j++){
        	
        	// if element at j is less than element at pivot index then .... 
            if(input[j] <= input[pivot]){
                i++;   // increase i, means small element index
                input[i] = input[j] + input [i] - (input[j] = input [i]); // swap elements at position i and j
            }    
        }
        
        // swapping of pivot element with its exact position element
        input[i+1] = input[pivot] + input [i+1] - (input[pivot] = input [i+1]);
        
        // calling recursive function for left sub array
        input = sort(input , start , i);
        
        // calling recursive function for right sub array
        input = sort(input , i+2 , end);
        
        // return sorted array
        return input;
    }
}