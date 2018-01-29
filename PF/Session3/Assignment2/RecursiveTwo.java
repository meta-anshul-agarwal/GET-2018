package PF.Session3.Assignment2;

import java.util.Arrays;
/**
 * 
 * @author Anshul Agarwal
 * This class consists of 3 methods - 
 * 1. linear search
 * 2. Binary search with 4 param
 * 3. Binary search with 2 param   
 */
public class RecursiveTwo {
	
	/**
	 * 
	 * @param x is searching element
	 * @param input is array in which searching is done
	 * @return true if element is found otherwise false
	 * Linear search method
	 */
	public boolean linearSearch(int x , int[] input){
		
		int n = input.length - 1; // last index of input array
		boolean result = false; // initialization of result variable 
		
		// base condition for false if length becomes 0 then return false, it implies empty of array
		if(input.length == 0){
			return false;
		}
		else{
			
			// base condition, checks x and last element of array, if element is found returns true
			if(x == input[n]){
				return true;
			}
			result = linearSearch(x, Arrays.copyOfRange(input, 0, n)); // function call itself with with array size less 1
		}
		return result;
	}

	/**
	 * 
	 * @param x is searching element
	 * @param input is array in which searching is done
	 * @param start is starting index
	 * @param end is ending index
	 * @return true if element is found otherwise false
	 * Binary Search method with 4 param
	 */
	public boolean binarySearch_withFourParam(int x, int[] input, int start,int end){
		
		int mid = (start+end)/2;  // middle index
		boolean result = false; // initialization of result variable 
		
		// base condition, if array elements are no more left then return false
		if(start >= end){ 
			return false;
		}
		
		// base condition , if element found then return false
		if(x == input[mid]){
			return true;
		}
		
		// checks if input number is greater than middle index element
		if(x > input[mid]){
			
			// call function with start index from mid+1
			result = binarySearch_withFourParam(x,input,mid+1,end);
		}
		
		// checks if input number is less than middle index element
		else{
			
			// call function with end index till mid-1
			result = binarySearch_withFourParam(x,input,start,mid-1);
		}
		return result;
	}

	/**
	 * 
	 * @param x is searching element
	 * @param input is array in which searching is done
	 * @return true if element is found otherwise false
	 * Binary Search method with 2 param
	 */
	public boolean binarySearch_withTwoParam(int x, int[] input){
		
		int start = 0; // initializing start
		int end = input.length ; // initializing end
		int mid = (start+end)/2; // middle index
		boolean result = false; // initialization of result variable 
		
		// base condition, if array elements are no more left then return false
		if(start >= end){
			return false;
		}
		
		// checks if input number is greater than middle index element
		if(x == input[mid]){
			return true;
		}
		
		// checks if input number is greater than middle index element
		if(x > input[mid]){
			
			// call function with sub array start index from mid+1
			result = binarySearch_withTwoParam(x,Arrays.copyOfRange(input,mid+1,end));
		}
		
		// checks if input number is less than middle index element
		else{
			
			// call function with sub array end index till mid-1
			result = binarySearch_withTwoParam(x,Arrays.copyOfRange(input,start,mid-1));
		}
		return result;
	}
}
