import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class LinkListTest {

	LinkList linkList;
	@Before
	public void init() {
		
		linkList = new LinkList();
		linkList.addElement(1);
		linkList.addElement(8);
		linkList.addElement(3);
		linkList.addElement(4);		
		linkList.addElement(6);
		linkList.addElement(7);
		linkList.addElement(8);
		linkList.addElement(9);
		linkList.addElement(5,5);
	}
	
	@Test
	public void testAddElement() {
		
		int[] expected = {1,8,3,4,5,6,7,8,9};
		int[] actual = linkList.show();
		assertArrayEquals(expected, actual);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testAddElementAtPosition() {
		linkList.addElement(12, 12);
	}
	
	@Test
	public void testRemoveElementByData() {
		
		linkList.removeElementByData(9);
		int[] expected = {1,8,3,4,5,6,7,8};
		int[] actual = linkList.show();
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testRemoveElementByDataException() {
		
		linkList.removeElementByData(10);
	}
	
	@Test
	public void testRemoveElementByIndex() {
		
		linkList.removeElementByIndex(8);
		int[] expected = {1,8,3,4,5,6,7,8};
		int[] actual = linkList.show();
		assertArrayEquals(expected, actual);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testRemoveElementByIndexException() {
		
		linkList.removeElementByIndex(11);
	}
	
	@Test
	public void testDataAtIndex() {
		
		int expected = 7;
		assertEquals(expected, linkList.dataByIndex(7));
	}
	
	@Test
	public void testReverse() {
		
		linkList.reverseList();
		int[] expected = {9,8,7,6,5,4,3,8,1};
		int[] actual = linkList.show();
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort() {
		
		linkList.sortList();
		int[] expected = {1,3,4,5,6,7,8,8,9};
		int[] actual = linkList.show();
		assertArrayEquals(expected, actual);
	}
}