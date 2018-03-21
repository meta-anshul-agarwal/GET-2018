package assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * this class traverses tree in post order fashion
 */
public class PostorderBST {
	
	//list to store result of traversal
	List<Integer> traversedPath = new ArrayList<>();
	
	/**
	 * method that performs traversal
	 * @param root - root node of tree to be traversed
	 * @return list of nodes
	 */
	public List<Integer> postOrder(BSTNode root) {
		
		//getting left of node
		if(root.left!=null) {
			postOrder(root.left);
		}
		//getting right of node
		if(root.right!=null) {
			postOrder(root.right);
		}
		//adding root
		traversedPath.add(root.data);
		return traversedPath;
	}
}
