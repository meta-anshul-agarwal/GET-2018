package PF.Session4.Assignment1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TowerOfHanoiTest {
	
	TowerOfHanoi towerofhanoi = new TowerOfHanoi();

	@Test
	public void testFor_twoDisks() {
		String[] expected = {"Move Disk 1 from A to C",
								"Move Disk 2 from A to B",
								"Move Disk 1 from C to B"  };
		List<String> result = new ArrayList<String>();
		List<String> myList = towerofhanoi.towerOfHanoi("A", "B", "C", 2,result);
		Object[] actual = myList.toArray();
		assertArrayEquals(expected, actual);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testFor_noDisks() {
		String[] expected = { };
		List<String> result = new ArrayList<String>();
		List<String> myList = towerofhanoi.towerOfHanoi("A", "B", "C", 0,result);
		Object[] actual = myList.toArray();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testFor_threeDisks() {
		String[] expected = { "Move Disk 1 from A to B",
							"Move Disk 2 from A to C",
							"Move Disk 1 from B to C",
							"Move Disk 3 from A to B",
							"Move Disk 1 from C to A",
							"Move Disk 2 from C to B",
							"Move Disk 1 from A to B" };
		List<String> result = new ArrayList<String>();
		List<String> myList = towerofhanoi.towerOfHanoi("A", "B", "C", 3,result);
		Object[] actual = myList.toArray();
		assertArrayEquals(expected, actual);
	}

}
