package PF.Session4.Assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

import PF.Session1.Assignment4.FCFSProcessingTest;

public class NqueenTest {
	
	Nqueen nqueen = new Nqueen();
	FCFSProcessingTest fcfs = new FCFSProcessingTest();

	@Test
	public void board4x4Test() {
		int[][] input = new int[][] {
				{ 0,  0,  0,  0},
	            { 0,  0,  0,  0},
	            { 0,  0,  0,  0},
	            { 0,  0,  0,  0} };
		assertTrue(nqueen.nQueen(input, 0, input.length));
	}
	
	@Test
	public void board1x1Test() {
		int[][] input = new int[][] {
				{ 0 } };
		assertTrue(nqueen.nQueen(input, 0, input.length));
	}
	
	@Test
	public void board3x3Test() {
		int[][] input = new int[][] {
				{ 0,  0,  0},
	            { 0,  0,  0},
	            { 0,  0,  0} };
		assertFalse(nqueen.nQueen(input, 0, input.length));
	}
	
	@Test
	public void board4x4_arrayTest() {
		int[][] input = new int[][] {
				{ 0,  0,  0,  0},
	            { 0,  0,  0,  0},
	            { 0,  0,  0,  0},
	            { 0,  0,  0,  0} };
		
		int[][] expected = new int[][] {
				{ 0,  1,  0,  0},
	            { 0,  0,  0,  1},
	            { 1,  0,  0,  0},
	            { 0,  0,  1,  0} };
		
		int[][] actual = nqueen.nQueen_solution(input);
		assertTrue(fcfs.isArrayEqual(actual, expected));
		
	}

}
