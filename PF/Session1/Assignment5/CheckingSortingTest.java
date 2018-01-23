package PF.Session1.Assignment5;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckingSortingTest {

	CheckingSorting checkingSorting = new CheckingSorting();
	
	@Test
	public void increasing_order_test() {
		
		int[] input = new int[] {1,2,3,4,5,6};
		int actual = checkingSorting.checkSort(input);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void decreasing_order_test() {
		
		int[] input = new int[] {6,4,3,2,1,-1};
		int actual = checkingSorting.checkSort(input);
		int expected = 2;
		assertEquals(expected, actual);
	}
	
	@Test
	public void equal_number_test() {
		
		int[] input = new int[] {1,1,1,1,1,1,1};
		int actual = checkingSorting.checkSort(input);
		int expected = 0;
		assertEquals(expected, actual);
	}
	@Test
	public void unsorted_number_test() {
		
		int[] input = new int[] {1,2,7,5,9,1};
		int actual = checkingSorting.checkSort(input);
		int expected = 0;
		assertEquals(expected, actual);
	}

}
