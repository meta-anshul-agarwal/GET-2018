package assignment1;

import java.util.ArrayList;
import java.util.List;

/**
 * this class traverses tree in pre order fashion
 */
public class PreorderBT{
	
	//list to store result of traversal
	List<Integer> traversedPath = new ArrayList<>();
	
	/**
	 * method that performs traversal
	 * @param root - root node of tree to be traversed
	 * @return list of nodes
	 */
	public List<Integer> preorder(BSTNode root) {
		
		//adding root
		traversedPath.add(root.data);
		//getting left of node
		if(root.left != null) {
			preorder(root.left);
		}
		//getting right of node
		if(root.right != null) {
			preorder(root.right);
		}
		return traversedPath;
	}
}



		
			
		
