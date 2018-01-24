package PF.Session2.Assignment2;

import static org.junit.Assert.*;
import org.junit.Test;
import PF.Session2.UserException.IllegalExpressionException;

public class SimplePatternTest {
	
	
	@Test
	public void IllegalExpressionTest() throws IllegalExpressionException{
		try{
			
			String actual = SimplePattern.spaces(7,3);
			String expected = "";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void SpaceTest() throws IllegalExpressionException{
		try{
			
			String actual = SimplePattern.spaces(1,3);
			String expected = " ";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
	
	@Test
	public void NumberTest() throws IllegalExpressionException{
		try{
			
			String actual = SimplePattern.numbers(1,3);
			String expected = "12";
			assertEquals(expected, actual);
			
		} catch(IllegalExpressionException e){
			
			throw new IllegalExpressionException(""+e);
		}
	}
}
