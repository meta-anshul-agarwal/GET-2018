package PF.Session1.Assignment3;

import java.util.Arrays;

/**
 * 
 * @author Anshul Agarwal
 * This class finds out the longest increasing subsequence
 *
 */
public class LongestIncreasingSubsequence {
		/**
		 * 
		 * @param input is an array
		 * @return longest subsequence array
		 */
		int[] longestSequence(int input[]){
			
			int index[] = new int[input.length]; // extra array of input length size which stores size of increasing subsequence
			int counter = 1;
			int lastSavedValue = 0; // last index where the value is saved otherwise MIN_VALUE is saved
			int rowCounter=0;
			
			for(rowCounter=0;rowCounter<input.length-1;rowCounter++){
				if(input[rowCounter] < input[counter]){
					index[rowCounter] = Integer.MIN_VALUE;
					counter++;
					continue;
				}
				else{
					
					index[rowCounter] = counter - lastSavedValue ;
					counter++;
					lastSavedValue = rowCounter+1; 
				}
			}
			
			if(rowCounter == (input.length-1)){   
				index[rowCounter] = counter - lastSavedValue;   // if last element is also a part of longest increasing subsequence then this conditions becomes true.
			}
			
			int maxValue = 0;  // maxValue is highest increasing sub sequence number
			int maxIndex = 0 ; // maxIndex is highest increasing sub sequence starting index
			
			for(rowCounter=0;rowCounter<index.length;rowCounter++){
				System.out.print(" "+index[rowCounter]);
				if (index[rowCounter] > maxValue){
					maxValue = index[rowCounter];
					maxIndex = rowCounter;
				}
			}
			
			// if all numbers are equal
			if(maxValue == Integer.MIN_VALUE){
				maxIndex = 0;
				maxValue = 1;
			}
			
			return Arrays.copyOfRange(input, maxIndex-maxValue+1, maxIndex+1);
		}
}
