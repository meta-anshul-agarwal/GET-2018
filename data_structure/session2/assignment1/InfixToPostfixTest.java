package assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InfixToPostfixTest {

	String infixExpression;
	String postfixExpression;
	InfixToPostfix infixToPostfixObject;
	
	
	@Before
	public void setUp() throws Exception {
		infixToPostfixObject = new InfixToPostfix();
		
	}

	@Test
	public void testGetPostfixSuccess() {
		infixExpression = "(( a + b ) - c) * d";
		postfixExpression = "ab+c-d*";
		assertEquals(postfixExpression, infixToPostfixObject.infixToPostfix(infixExpression) );
	}

	@Test
	public void testGetPostfixFailure() {
		infixExpression = "(( a + b ) - c) * d";
		postfixExpression = "ab+c-d";
		assertNotEquals(postfixExpression, infixToPostfixObject.infixToPostfix(infixExpression) );
	}
}
