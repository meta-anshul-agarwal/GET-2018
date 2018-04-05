package assignment2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomAllocationTest {

	Guest[] allocatedRoomsActual;
	Guest[] allocatedRoomsExpected;
	HashClass obj;
	
	@Test
	public void testAllottingRoomSuccess() {
		obj = new HashClass(5);
		Guest g1 = new Guest("a", 11);
		allocatedRoomsActual = obj.allocateRoom(g1);
		Guest g2 = new Guest("b", 7);
		allocatedRoomsActual = obj.allocateRoom(g2);
		Guest g3 = new Guest("c", 17);
		allocatedRoomsActual = obj.allocateRoom(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = obj.allocateRoom(g4);
		allocatedRoomsExpected = new Guest[]{null , g1,g2 ,g3 ,g4};
		assertArrayEquals(allocatedRoomsExpected, allocatedRoomsActual);
	}
	
	@Test
	public void testAllottingRoomFailure() {
		obj = new HashClass(5);
		Guest g1 = new Guest("a", 11);
		allocatedRoomsActual = obj.allocateRoom(g1);
		Guest g2 = new Guest("b", 7);
		allocatedRoomsActual = obj.allocateRoom(g2);
		Guest g3 = new Guest("c", 17);
		allocatedRoomsActual = obj.allocateRoom(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = obj.allocateRoom(g4);
		allocatedRoomsExpected = new Guest[]{ g1,g2 ,g3 ,g4};
		assertNotEquals(allocatedRoomsExpected, allocatedRoomsActual);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testException() {
		obj = new HashClass(5);
		Guest g1 = new Guest("a", 11);
		allocatedRoomsActual = obj.allocateRoom(g1);
		Guest g2 = new Guest("b", 7);
		allocatedRoomsActual = obj.allocateRoom(g2);
		Guest g3 = new Guest("c", 17);
		allocatedRoomsActual = obj.allocateRoom(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = obj.allocateRoom(g4);
		Guest g5 = new Guest("e", 14);
		allocatedRoomsActual = obj.allocateRoom(g5);
		Guest g6 = new Guest("f", 14);
		allocatedRoomsActual = obj.allocateRoom(g6);
		allocatedRoomsExpected = new Guest[]{null, g1,g2 ,g3 ,g4};
	}
	
	
	@Test
	public void testSearchGuestNotFound() {
		obj = new HashClass(5);
		Guest g1 = new Guest("a", 11);
		allocatedRoomsActual = obj.allocateRoom(g1);
		Guest g2 = new Guest("b", 7);
		allocatedRoomsActual = obj.allocateRoom(g2);
		Guest g3 = new Guest("c", 17);
		allocatedRoomsActual = obj.allocateRoom(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = obj.allocateRoom(g4);
		String actual = obj.getGuestDetails("a", 7);
		String expected = "not found";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchGuestFound() {
		obj = new HashClass(5);
		Guest g1 = new Guest("a", 11);
		allocatedRoomsActual = obj.allocateRoom(g1);
		Guest g2 = new Guest("b", 7);
		allocatedRoomsActual = obj.allocateRoom(g2);
		Guest g3 = new Guest("c", 17);
		allocatedRoomsActual = obj.allocateRoom(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = obj.allocateRoom(g4);
		String actual = obj.getGuestDetails("a",11);
		String expected = "name is a  room no is 1";
		assertEquals(expected, actual);
	}
	
}
