package PF.Session1.Assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinaryToOctalTest {
	
	BinaryToOctal binaryToOctal;
	
	@Before
	public void setUp(){
		binaryToOctal = new BinaryToOctal();
	}

	@Test
	public void BinaryToOctal_correctCase_test() {
		assertEquals(16, binaryToOctal.octalConversion(001110));
	}
	
	@Test
	public void BinaryToOctal_outOfBoundNumber_test() {
		assertEquals(49, binaryToOctal.octalConversion(100010));
	}
	
	@Test
	public void BinaryToOctal_wrongExpectedNumber_test() {
		assertEquals(46, binaryToOctal.octalConversion(100111));
	}
	
	@Test
	public void BinaryToOctal_negativeNumber_test() {
		assertEquals(-20, binaryToOctal.octalConversion(100000));
	}
	
	

}
