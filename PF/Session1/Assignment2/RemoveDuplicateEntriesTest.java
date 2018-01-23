package PF.Session1.Assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicateEntriesTest {
	
	RemoveDuplicateEntries removeDuplicateEntries;

	@Test
	public void positiveNumbersTest() {
		
		int[] input = new int[] {2,3,4,1,2,5,3,7};
		removeDuplicateEntries = new RemoveDuplicateEntries(input.length);
		int[] actual = removeDuplicateEntries.removeDuplicate(input);
		int[] expected = new int[] {2,3,4,1,5,7};
		assertArrayEquals(expected, actual);		
	}
	
	@Test
	public void negativeNumbersTest() {
		
		int[] input = new int[] {-2,-3,-4,-9,-2,-5,-3,-7};
		removeDuplicateEntries = new RemoveDuplicateEntries(input.length);
		int[] actual = removeDuplicateEntries.removeDuplicate(input);
		int[] expected = new int[] {-2,-3,-4,-9,-5,-7};
		assertArrayEquals(expected, actual);		
	}
	
	@Test
	public void falseTest() {
		
		int[] input = new int[] {-2,-3,-4,9,-2,-5,-3,-7};
		removeDuplicateEntries = new RemoveDuplicateEntries(input.length);
		int[] actual = removeDuplicateEntries.removeDuplicate(input);
		int[] expected = new int[] {-2,-3,-4,-9,-5,-7};
		assertArrayEquals(expected, actual);	
	}
}
