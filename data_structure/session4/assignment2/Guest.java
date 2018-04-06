package assignment2;

/**
 * This class represents the guest entity
 *
 */
public class Guest {

	String name;
	int age;
	int roomNo;
	
	/**
	 * constructor to initialize guest object
	 * @param name
	 * @param age
	 */
	public Guest(String name, int age) {
		
		this.name = name;
		this.age = age;
		this.roomNo = -1;
	}

	/**
	 * getter method for name
	 * @return name of guest
	 */ 
	public String getName() {
		return name;
	}

	/**
	 * getter method for room number
	 * @return room number of guest
	 */
	public int getRoomNo() {
		return roomNo;
	}

	/**
	 * method to get the age
	 * @return age of guest
	 */
	public int getAge() {
		return age;
	}

	/**
	 * method to set the room umber of guest
	 * @param roomNo 
	 */
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

}
