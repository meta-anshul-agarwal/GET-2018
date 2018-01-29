package PF.Session3.Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveTwoTest {
	
	RecursiveTwo recursivetwo = new RecursiveTwo();

	@Test
	public void linearSearchTest_one() {
		int[] input = new int[] {2,5,8,9,10, 77, 55};
		int x = 77;
		assertTrue(recursivetwo.linearSearch(x, input));
	}
	
	@Test
	public void linearSearchTest_two() {
		int[] input = new int[] {2,5,8,9,10, 77, 55};
		int x = 88;
		assertFalse(recursivetwo.linearSearch(x, input));
	}
	
	@Test
	public void linearSearchTest_emptyArray() {
		int[] input = new int[] {};
		int x = 88;
		assertFalse(recursivetwo.linearSearch(x, input));
	}
	
	@Test
	public void binarySearchTest_withFourParam_one() {
		int[] input = new int[] {2,5,8,9,10, 55, 77};
		int x = 77;
		assertTrue(recursivetwo.binarySearch_withFourParam(x, input,0,input.length));
	}
	
	@Test
	public void binarySearchTest_withFourParam_two() {
		int[] input = new int[] {2,5,8,9,10, 55, 77};
		int x = 88;
		assertFalse(recursivetwo.binarySearch_withFourParam(x, input,0,input.length));
	}

	@Test
	public void binarySearchTest_withFourParam_emptyArray() {
		int[] input = new int[] {};
		int x = 88;
		assertFalse(recursivetwo.binarySearch_withFourParam(x, input,0,input.length));
	}
	
	@Test
	public void binarySearchTest_withTwoParam_one() {
		int[] input = new int[] {2,5,8,9,10, 55, 77};
		int x = 77;
		assertTrue(recursivetwo.binarySearch_withTwoParam(x, input));
	}
	
	@Test
	public void binarySearchTest_withTwoParam_two() {
		int[] input = new int[] {2,5,8,9,10, 55, 77};
		int x = 88;
		assertFalse(recursivetwo.binarySearch_withTwoParam(x, input));
	}
	
	@Test
	public void binarySearchTest_withTwoParam_emptyArray() {
		int[] input = new int[] {};
		int x = 88;
		assertFalse(recursivetwo.binarySearch_withTwoParam(x, input));
	}
}
