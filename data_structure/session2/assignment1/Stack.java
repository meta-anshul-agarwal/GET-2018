package assignment1;

/**
 * this class is used implement stack
 */
public class Stack {

	Node top;
	
	/**
	 * push function is used to insert an element in the stack
	 * @param data - the data to be entered in the stack
	 */
	void push(char data) {
		Node newNode = new Node();
		newNode.data = data;
		
		//to check whether stack is already created or not
		if(top != null) {
			newNode.next = top;
		}
		top = newNode;
	}
	
	/**
	 * pop function is used to pop out an element of the array
	 * @return character
	 */
	char pop() {
		if(top != null) {
			char data = top.data;
			if(top.next != null) {
				top = top.next;
			} else {
				top = null;
			}
			return data;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
}
