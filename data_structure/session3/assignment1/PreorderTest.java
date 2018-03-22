package assignment1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PreorderTest {

	BSTNode root;
	PreorderBT preorderTraverse;
	List<Integer> actualTraversedPath = new ArrayList<>();
	List<Integer> expectedTraversedPath = new ArrayList<>();
	
	@Test
	public void testBalancedB() {
		root = new BSTNode(10);
		root.addItem(6);
		root.addItem(45);
		root.addItem(8);
		root.addItem(23);
		root.addItem(54);
		root.addItem(60);
		root.addItem(4);
		preorderTraverse = new PreorderBT();
        actualTraversedPath = preorderTraverse.preorder(root);
        expectedTraversedPath.add(10);
        expectedTraversedPath.add(6);
        expectedTraversedPath.add(4);
        expectedTraversedPath.add(8);
        expectedTraversedPath.add(45);
        expectedTraversedPath.add(23);
        expectedTraversedPath.add(54);
        expectedTraversedPath.add(60);
        assertEquals(expectedTraversedPath, actualTraversedPath);
	}

	@Test
	public void testRightSkewTreeSuccess() {
		root = new BSTNode(22);
		root.addItem(25);
		root.addItem(45);
		root.addItem(80);
		preorderTraverse = new PreorderBT();
        actualTraversedPath = preorderTraverse.preorder(root);
        expectedTraversedPath.add(22);
        expectedTraversedPath.add(25);
        expectedTraversedPath.add(45);
        expectedTraversedPath.add(80);
        assertEquals(expectedTraversedPath, actualTraversedPath);
	}
	
	@Test
	public void testLeftSkewTreeSuccess() {
		root = new BSTNode(22);
		root.addItem(20);
		root.addItem(4);
		root.addItem(0);
		preorderTraverse = new PreorderBT();
        actualTraversedPath = preorderTraverse.preorder(root);
        expectedTraversedPath.add(22);
        expectedTraversedPath.add(20);
        expectedTraversedPath.add(4);
        expectedTraversedPath.add(0);
        assertEquals(expectedTraversedPath, actualTraversedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullTreeSuccess() {
		root = new BSTNode((Integer) null);
		preorderTraverse = new PreorderBT();
        actualTraversedPath = preorderTraverse.preorder(root);
        expectedTraversedPath.add(null);
        assertEquals(expectedTraversedPath, actualTraversedPath);
	}
}
