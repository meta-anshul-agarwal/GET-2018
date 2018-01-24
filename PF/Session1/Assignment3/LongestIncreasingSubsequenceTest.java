package PF.Session1.Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestIncreasingSubsequenceTest {

	LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
	
	@Test
	public void positiveNumberTest() {
		
		int input[] = new int[] {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int actual[] = longestIncreasingSubsequence.longestSequence(input);
		int[] expected = new int[] {1,2,4,5,6,7,8,9};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void negativeNumberTest() {
		
		int input[] = new int[] {-1,-2,-3,-5,-4,-3,-2,-3,-4,-1,-2,-3,-4,-5,-6,-7,-8,-1,-2,-4,-5,-6,-7,-8};
		int actual[] = longestIncreasingSubsequence.longestSequence(input);
		int[] expected = new int[] {-5,-4,-3,-2};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void emptyNumberTest() {
		
			int input[] = new int[] {};
			int actual[] = longestIncreasingSubsequence.longestSequence(input);
			int[] expected = new int[] {};
			assertArrayEquals(expected, actual);
		
	}
	
	@Test
	public void mixedNumberTest() {
		
		int input[] = new int[] {-1,-2,3,5,-4,-3,2,-3,4,-1,-2,3,4,5,6,-7,-8,-1,-2,4,5,-6,-7,-8};
		int actual[] = longestIncreasingSubsequence.longestSequence(input);
		int[] expected = new int[] {-2,3,4,5,6};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void equalNumberTest() {
		
		int input[] = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		int actual[] = longestIncreasingSubsequence.longestSequence(input);
		int[] expected = new int[] {1};
		assertArrayEquals(expected, actual);
	}
}
