import java.util.NoSuchElementException;

/*
 * This file contains a class for doublyLinkList
 */

/**
 * This class is used  to make a doubly link list
 * @author Anshul Agarwal
 */
public class DoublyLinkList {
	
	Node startNode;							//Contains the address of starting node of the list
	Node lastNode;							//Contains the address of last node of the list
	
	/**
	 * Used to add an element at the end of the list
	 * @param {int}data - the data to be added
	 */
	void addElement(int data){
		Node newNode = new Node();			//making a new node
		newNode.data = data;
		
		/* adding the node when list is empty */
		if(startNode == null) {
			startNode = newNode;
		}
		else {
			newNode.previous = lastNode;
			lastNode.next = newNode;
		}
		
		lastNode = newNode;
	}
	
	/**
	 * Used to add element at a particular position
	 * @param {int}data - the data to be added
	 * @param {int}position - the position at which the data is to be added
	 */
	void addElement(int data,int position){
		Node start = startNode;
		int i;
		
		/* Used to traverse the list to the position needed */
		for(i = 1; (i < position - 1) && (start != null); i++){
			start = start.next;
		}
		
		/* checking for index out of bound */
		if((start != null) && (i <= position)){
			Node newNode = new Node();
			newNode.data = data;
			
			/*For adding element at the start of the list*/
			if(position == 1){
				newNode.previous = null;
				newNode.next = start;
				start.previous = newNode;
				startNode = newNode;				
			}
			else{
				
				/*check to add element at the ending of the list*/
				if(start != lastNode){
					
					start.next.previous = newNode;
					newNode.next = start.next;	
				}
				else{
					
					lastNode = newNode;
					newNode.next = null;
				}
				
				start.next = newNode;
				newNode.previous = start;
			}
		}
		
		/*exception for the case position is larger than the list*/
		else{
			throw new ArrayIndexOutOfBoundsException(i);
		}
	}
	
	/**
	 * This function is used to remove data from the linked list
	 * @param {int}data - data to be removed from the list
	 */
	void removeByData(int data){
		Node start = startNode;
		
		/*Searching for the data to be removed*/
		while(start.next != null){
			if(start.data == data){
				break;
			}
			start = start.next;
		}
		if((start == lastNode) && (start.data != data)) {
			throw new NoSuchElementException();
		}
		if(start == startNode){
			startNode = start.next;
		}
		if(start != lastNode){
			start.previous.next = start.next;
			start.next.previous = start.previous;
		}
		else{
			start.previous.next = null;
		}
	}
	
	/**
	 * This function is used to remove data at a particular index in the list
	 * @param {int}position - position from which data is to be removed
	 */
	void removeByIndex(int position){
		Node start = startNode;
		int i;
		
		/* Used to traverse the list to the position needed */
		for(i = 1; (i < position) && (start != null) ; i++){
			start = start.next;
		}
		
		/* checking for index out of bound */
		if((start != null) && (i <= position)){
			start.previous.next = start.next;
			start.next.previous = start.previous;
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Used to return a data at a particular index
	 * @param {int}position - position at which data have to be returned
	 * @return
	 */
	public int dataByIndex(int position){
		Node start = startNode;
		int i;
		
		/*Use to traverse till the position*/
		for(i = 1; (i < position)&&(start != null) ; i++){
			start = start.next;
		}
		
		/*Checking for index out of bound*/
		if((start != null) && (i <= position)){
			return start.data;
		}
		else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * Function used to reverse the list
	 */
	public void reverseLinkList(){
		int size = getSize();
		Node start = startNode;
		Node last = lastNode;
		int temp;
		
		/*Used to swap the first and last element of the list*/
		for(int i = 0; i < (size / 2); i++){
			
			/*swap*/
			temp = start.data;
			start.data  = last.data;
			last.data = temp;
		
			start = start.next;
			last = last.previous;
		}
	}
	
	/**
	 * private function used to get the size of the list
	 * @return {int}
	 */
	private int getSize(){
		int i= 0 ;
		Node start = startNode;
		while(start != null){
			i++;
			start = start.next;
		}
		return i;
	}
	
	/**
	 * This function is used to sort the list
	 */
	public void sortLinkList(){
		int size = getSize();
		Node start = startNode.next;
		
		/*Insertion sort is used to sort this list out*/
		for (int i=1; i < size; ++i)
        {
            int key = start.data;
            Node j = start.previous;
            while (j != null && j.data > key)
            {
                j.next.data = j.data;
                j = j.previous;
            }
            j.next.data = key;
            start = start.next;
        }
	}
	
	/**
	 * Function used to show the list
	 */
	int[] show(){
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
