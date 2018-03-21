package assignment2;

/**
 * this class contains methods to compare both trees
 * if they are mirror or not.
 *
 */
public class CompareTree {

	/**
	 * method to check if trees are mirror or not
	 * @param leftTree - root of left side tree
	 * @param rightTree - root of right side tree
	 * @return
	 */
	public boolean compareMirrorTree(BTNode leftTree, BTNode rightTree){
		
		if( (leftTree != null && rightTree != null) && (leftTree.data == rightTree.data) ) {
			//moving left of left tree and right of right tree
			if ( compareMirrorTree(leftTree.left, rightTree.right) ) {
				//moving right of left tree and left of right tree
				if( compareMirrorTree(leftTree.right, rightTree.left) ) {
					//if trees are mirror
					return true;
				}
			}
		} else if(leftTree == null && rightTree == null) {
			//if trees are null
			return true;
		}
		return false;
		
	}
}
