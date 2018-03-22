import java.util.NoSuchElementException;

/*
 * This file contains a class for SinglyLinkKist
 */

/**
 * This class is used  to make a singly link list
 * @author Anshul Agarwal
 */
public class LinkList {

	Node startNode = null;								//Contains the address of starting node of the list			
	Node lastNode = null;								//Contains the address of last node of the list
	
	/**
	 * Used to add an element at the end of the list
	 * @param {int}data - the data to be added
	 */
	void addElement(int data) {
		Node newNode = new Node();						//making a new node
		newNode.data = data;
		newNode.next = null;
		
		/* adding the node when list is empty */
		if(startNode == null) {
			startNode = newNode;		
		}
		else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}
	
	/**
	 * Used to add element at a particular position
	 * @param {int}data - the data to be added
	 * @param {int}position - the position at which the data is to be added
	 */
	void addElement(int data, int position) {
		Node newNode = new Node();
		newNode.data = data;
		Node start = startNode;
		
		/*For adding element at the start of the list*/
		if(position == 1) {
			newNode.next = startNode;
			startNode = newNode;
		}
		else {
			
			/* Used to traverse the list to the position needed */
			for(int i = 1; (i < position - 1) && (start != null); i++) {
				start = start.next;
			}
			
			/* checking for index out of bound */
			if(start != null) {
				
				/*check to add element at the ending of the list*/
				if(start == lastNode) {
					newNode.next = null;
				}
				else {
					newNode.next = start.next;
				}
				start.next = newNode;
			}
			
			/*exception for the case position is larger than the list*/
			else {
				throw new ArrayIndexOutOfBoundsException();
			}
		}
	}
	
	/**
	 * This function is used to remove data from the linked list
	 * @param {int}data - data to be removed from the list
	 */
	void removeElementByData(int data) {
		Node start = startNode;
	
		/*Searching for the data to be removed*/
		while(start.next != null) {
			if(start.next.data == data) {
				break;
			}
			start = start.next;
		}
		if((start==lastNode) && (start.data != data)) {
			throw new NoSuchElementException();
		}
		start.next = start.next.next;
	}
	
	/**
	 * This function is used to remove data at a particular index in the list
	 * @param {int}position - position from which data is to be removed
	 */
	void removeElementByIndex(int position) {
		Node start = startNode;
		int i;
		
		/* Used to traverse the list to the position needed */
		for(i = 1; (i < position) && (start != null); i++) {
			start = start.next;
		}
		
		/* checking for index out of bound */
		if((start != null) && (i <= position)) {
			start.next = start.next.next;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Used to return a data at a particular index
	 * @param {int}position - position at which data have to be returned
	 * @return
	 */
	int dataByIndex(int position) {
		Node start = startNode;
		
		/*Use to traverse till the position*/
		for(int i = 1; (i < position) && (start != null); i++) {
			start = start.next;
		}

		/*Checking for index out of bound*/
		if(start != null){
			return start.data;
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Function used to reverse the list
	 */
	void reverseList() {
		int size = getSize();
		Node tempStart = startNode;
		int[] temp = new int[size]; 					//temp array used to store the link list	
		
		/*loop used to fill the array*/
		for(int i = 0; i < size; i++) {
			temp[i] = tempStart.data;
			tempStart = tempStart.next;
		}
		
		tempStart = startNode;
		
		/*initializing the reverse back*/
		for(int i = size - 1; i >= 0; i--) {
			tempStart.data = temp[i];
			tempStart = tempStart.next;
		}
	}
	
	/**
	 * This function is used to sort the list
	 */
	void sortList() {		
		int size = getSize();
		Node tempStart = startNode;
		int[] temp = new int[size];					//temp array used to store the link list	
		
		/*initializing the array*/
		for(int i = 0; i < size; i++) {
			temp[i] = tempStart.data;
			tempStart = tempStart.next;
		}
		
		QuickSort q = new QuickSort();
		q.sort(temp, 0, size - 1);
		tempStart = startNode;
		
		/*initialing back the list*/
		for(int i = 0; i < size; i++) {
			tempStart.data = temp[i];
			tempStart = tempStart.next;
		}
	}
	
	/**
	 * private function used to get the size of the list
	 * @return {int}
	 */
	private int getSize() {
		int size = 0;
		Node tempStart = startNode;
		
		while(tempStart != null) {
			size++;
			tempStart = tempStart.next;
		}
		return size;
	}
	
	/**
	 * Function used to show the list
	 */
	int[] show() {
		int size = getSize();
		Node tempStart = startNode;
		int[] linkList = new int[size];					//temp array used to store the link list	
		
		/*initializing the array*/
		for(int i = 0; i < size; i++) {
			linkList[i] = tempStart.data;
			tempStart = tempStart.next;
		}
		return linkList;
	}
}