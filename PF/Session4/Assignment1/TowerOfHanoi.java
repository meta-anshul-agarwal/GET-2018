package PF.Session4.Assignment1;

import java.util.List;

/**
 * 
 * @author Anshul Agarwal
 * 
 * The Tower of Hanoi is a mathematical game or puzzle. It consists of three rods and a number of disks of different sizes, which can slide onto any rod. The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top, thus making a conical shape.
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * 1. Only one disk can be moved at a time.
 * 2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack.
 * 3. No disk may be placed on top of a smaller disk.
 */
public class TowerOfHanoi { 
	/**
	 * 
	 * @param source tower is a string
	 * @param destination tower is a string
	 * @param temp is auxiliary tower is string
	 * @param numOfDisk is integer
	 * @param result is List which consists all the movement
	 * @return result (List)
	 */
	public List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk,List<String> result){
		
		// checks for legal argument, numOfDisk should not be 0
		if(numOfDisk == 0){
			
			throw new IllegalArgumentException();
		}
		
		// base condition
		if (numOfDisk == 1)
	    {
			// adding the last moving disk details to the List 
	        result.add("Move Disk 1 from "+source+" to "+destination);
	        
	        // returning the list
	        return result;
	    }
		
		// n-1 disk should move from source to auxiliary tower using destination tower, calling recursive function
	    towerOfHanoi(source, temp, destination,numOfDisk-1,result);
	    
	    // adding the moving disk details to the List 
	    result.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
	    
		// n-1 disk should move from auxiliary to destination tower using source tower, calling recursive function
	    towerOfHanoi(temp, destination, source,numOfDisk-1,result);
	    
        // returning the list
	    return result;
	}

}