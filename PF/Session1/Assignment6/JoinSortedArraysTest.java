package PF.Session1.Assignment6;

import static org.junit.Assert.*;

import org.junit.Test;

public class JoinSortedArraysTest {

	JoinSortedArrays joinSortedArrays = new JoinSortedArrays(); 
	
	@Test
	public void positive_number_test() {
		
		int[] input1 = new int[] {1,2,3,4,5,6};
		int[] input2 = new int[] {7,8,9,10};
		int[] actual = new int[input1.length+input2.length];
		actual =joinSortedArrays.join(input1, input1.length, input2
				, input2.length,actual);
		int[] expected = new int[] {1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void negative_number_test() {
		
		int[] input1 = new int[] {-6,-5,-4,-3,-2,-1};
		int[] input2 = new int[] {-10,-9,-8,-7};
		int[] actual = new int[input1.length+input2.length];
		actual =joinSortedArrays.join(input1, input1.length, input2
				, input2.length,actual);
		int[] expected = new int[] {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
		assertArrayEquals(expected, actual);
	}

}
