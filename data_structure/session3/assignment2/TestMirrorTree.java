package assignment2;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestMirrorTree {
	
	BTNode rootLeft;
	BTNode rootRight;
	CompareTree ct = new CompareTree();
	
	@Test
	public void testMirrorTreeSuccess() {
		rootLeft = new BTNode(10);
		rootLeft.addItem(6);
		rootLeft.addItem(30);
		rootLeft.addItem(4);
		rootLeft.addItem(8);
		rootLeft.addItem(28);
		rootLeft.addItem(31);
		rootRight = new BTNode(10);
		rootRight.addItemReverse(30);
		rootRight.addItemReverse(6);
		rootRight.addItemReverse(31);
		rootRight.addItemReverse(28);
		rootRight.addItemReverse(8);
		rootRight.addItemReverse(4);
		assertTrue(ct.compareMirrorTree(rootLeft, rootRight));
	}
	
	@Test
	public void testNotMirrorTreesSuccess() {
		rootLeft = new BTNode(10);
		rootLeft.addItem(6);
		rootLeft.addItem(30);
		rootLeft.addItem(4);
		rootLeft.addItem(8);
		rootLeft.addItem(28);
		rootLeft.addItem(31);
		rootRight = new BTNode(10);
		rootRight.addItemReverse(30);
		rootRight.addItemReverse(6);
		rootRight.addItemReverse(31);
		rootRight.addItemReverse(28);
		rootRight.addItemReverse(8);
		assertFalse(ct.compareMirrorTree(rootLeft, rootRight));
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullTreesSuccess() {
		rootLeft = new BTNode((Integer) null);
		rootRight = new BTNode((Integer) null);
		assertTrue(ct.compareMirrorTree(rootLeft, rootRight));
	}
	

}
