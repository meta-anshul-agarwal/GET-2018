package assignment3;

/**
 * this class creates the tree using the given methods
 */
public class BSTNode {

	public int data;
	public BSTNode left;
	public BSTNode right;
	
	/**
	 * constructor to initialize the node
	 * @param data
	 */
	public BSTNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	 /**
	 * method to create binary search tree
	 * @param num
	 */
	public void addItem(int num) {
		//left sub tree
		if(num < this.data) {
			if(this.left !=null) {
				this.left.addItem(num);
			} else {
				this.left = new BSTNode(num);
			}
		} else {
			//right sub tree
			if(this.right !=null) {
				this.right.addItem(num);
			} else {
				this.right = new BSTNode(num);
			}
		}
	}
}
