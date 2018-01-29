package PF.Session3.Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {
	
	QuickSort quicksort = new QuickSort();

	@Test
	public void emptyArrayTest() {
		int[] input = new int[] {};
		int[] expected = new int[] {};
		assertArrayEquals(expected, quicksort.sort(input, 0,input.length-1));
	}
	
	@Test
	public void SimpleTest() {
		int[] input = new int[] {10,30,60,20,40};
		int[] expected = new int[] {10,20,30,40,60};
		assertArrayEquals(expected, quicksort.sort(input, 0,input.length-1));
	}

}
