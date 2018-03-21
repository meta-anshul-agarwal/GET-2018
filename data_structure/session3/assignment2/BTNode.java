package assignment2;

/**
 * this class creates the tree using the given methods
 */
public class BTNode {

	public int data;
	public BTNode left;
	public BTNode right;
	
	/**
	 * constructor to initailize the node
	 * @param data
	 */
	public BTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * method to create binary search tree
	 * left tree when comparing
	 * @param num
	 */
	public void addItem(int num) {
		
		//left sub tree
		if(num < this.data) {
			if(this.left !=null) {
				this.left.addItem(num);
			} else {
				this.left = new BTNode(num);
			}
		} else { 
			//right sub tree
			if(this.right !=null) {
				this.right.addItem(num);
			} else {
				this.right = new BTNode(num);
			}
		}
	}
	
	/**
	 * method to create binary tree 
	 * right tree when comparing
	 * @param num
	 */
	public void addItemReverse(int num) {
		
		//left sub tree
		if(num > this.data) {
			if(this.left !=null) {
				this.left.addItemReverse(num);
			} else {
				this.left = new BTNode(num);
			}
		} else {
			//right sub tree
			if(this.right !=null) {
				this.right.addItemReverse(num);
			} else {
				this.right = new BTNode(num);
			}
		}
	}
}
