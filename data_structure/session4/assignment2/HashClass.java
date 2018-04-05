package assignment2;

/**
 * This class implements methods to allot rooms to guests
 * according to age and search room no. 
 *
 */
public class HashClass {

	//array of guest type
	Guest[] allocatedRooms ;
	//number of rooms available
	int numOfRooms;
	
	/**
	 * constructor to initialize object of hash class
	 * @param numOfRooms
	 */
	public HashClass(int numOfRooms) {
		
		this.numOfRooms = numOfRooms;
		this.allocatedRooms = new Guest[numOfRooms];
	}
	
	/**
	 * this method implements hash function to generate room 
	 * number according to age of guest
	 * @param age - age of guest to be allotted room
	 * @return room number
	 */
	private int generateRoomno(int age) {
		
		return age % numOfRooms;
	}
	
	/**
	 * method that invokes generateroomno to get 
	 * room no and assigns room to that guest.
	 * @param guest -object of guest type 
	 * @return array of guests with room no allotted
	 */
	public Guest[] allocateRoom(Guest guest) {
		
		int roomNum = 0;
		int flag = 0;
		//to count no of rooms allotted
		while(allocatedRooms[flag] != null) {
					flag++;
				}
		//to check if any room is empty or not
		if(flag == numOfRooms) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			roomNum = generateRoomno(guest.getAge());
			//wrap around condition
			while(allocatedRooms[roomNum] != null) {
				roomNum = (roomNum + 1) % numOfRooms;
		}
		
		allocatedRooms[roomNum] = guest;
		guest.setRoomNo(roomNum);

		return allocatedRooms;
		}
	}
	
	/**
	 * method to search for a particular guest's details
	 * @param name
	 * @param age
	 * @return 
	 */
	public String getGuestDetails(String name, int age) {
		
		for(int i = 0; i < numOfRooms; i++) {
			if(allocatedRooms[i] == null) {
				continue;
			}
			if(allocatedRooms[i].getAge() == age && allocatedRooms[i].getName() == name) {
				return  "name is " + name + "  room no is " + allocatedRooms[i].getRoomNo();
			}
		}
		return "not found";
	}
}
