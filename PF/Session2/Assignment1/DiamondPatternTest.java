package PF.Session2.Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

import PF.Session2.UserException.IllegalExpressionException;


public class DiamondPatternTest {
	
	DiamondPattern diamondpattern = new DiamondPattern();
	
	@Test
	public void IllegalExpressionTest() throws IllegalExpressionException{
		try{
			
			String actual = diamondpattern.spaces(7,3);
			String expected = "";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void SpaceTest() throws IllegalExpressionException{
		try{
			
			String actual = diamondpattern.spaces(1,3);
			String expected = " ";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void NumberTest() throws IllegalExpressionException{
		try{
			
			String actual = diamondpattern.numbers(1,3);
			String expected = "121";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void patternTest() throws IllegalExpressionException{
		try{
			String[] actual = diamondpattern.printPattern(5);
			String[] expected = new String[] {"    1","   121","  12321"," 1234321","123454321"," 1234321","  12321","   121","    1"};
			assertArrayEquals(expected, actual);
		} catch(IllegalExpressionException e){
			throw new IllegalExpressionException(""+e);
		}
	}

}
