package PF.Session4.Assignment2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class GeneratePermutationTest {

	GeneratePermutation generatepermutation = new GeneratePermutation();
	
	@Test
	public void threeCharTest() {
		String[] expected = {"ABC","ACB","BAC","BCA","CBA","CAB"};
		List<String> myList = generatepermutation.generatePermutations("ABC");
		Object[] actual;
		actual = myList.toArray();
		assertArrayEquals(expected, actual);	
	}
	
	@Test
	public void fourCharTest() {
		String[] expected = {"ABCD","ABDC","ACBD","ACDB","ADCB","ADBC","BACD","BADC","BCAD","BCDA","BDCA","BDAC","CBAD",
								"CBDA","CABD","CADB","CDAB","CDBA","DBCA","DBAC","DCBA","DCAB","DACB","DABC"};
		List<String> myList = generatepermutation.generatePermutations("ABCD");
		Object[] actual;
		actual = myList.toArray();
		assertArrayEquals(expected, actual);	
	}

}
