package PF.Session2.Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

import PF.Session2.UserException.IllegalExpressionException;


public class DiamondPatternTest {
	
	DiamondPattern diamondpattern = new DiamondPattern();
	
	@Test
	public void IllegalExpressionTest() throws IllegalExpressionException{
		try{
			
			String actual = DiamondPattern.spaces(7,3);
			String expected = "";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void SpaceTest() throws IllegalExpressionException{
		try{
			
			String actual = DiamondPattern.spaces(1,3);
			String expected = " ";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void NumberTest() throws IllegalExpressionException{
		try{
			
			String actual = DiamondPattern.numbers(1,3);
			String expected = "121";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}

}
