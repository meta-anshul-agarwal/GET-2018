package PF.Session3.Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveOneTest {
	RecursiveOne recursiveone = new RecursiveOne();
	
	@Test
	public void remainderTest_one() {
		assertEquals(0, recursiveone.rem(2, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void remainderTest_two() {
		assertEquals(0, recursiveone.rem(2, 0));
	}
	
	@Test
	public void remainderTest_three() {
		assertEquals(1, recursiveone.rem(100, 3));
	}
	
	@Test
	public void gcd_one() {
		assertEquals(1, recursiveone.gcd(2, 1));
	}
	
	@Test
	public void gcd_two() {
		assertEquals(6, recursiveone.gcd(12, 18));
	}
	
	@Test
	public void gcd_three() {
		assertEquals(1, recursiveone.gcd(100, 3));
	}
	
	@Test
	public void largestDigitTest() {
		assertEquals(9, recursiveone.largestDigit(1257369));
	}

	@Test
	public void largestDigitTest_withZero() {
		assertEquals(0, recursiveone.largestDigit(0));
	}
	
	@Test
	public void largestDigitTest_withSameNumber() {
		assertEquals(4, recursiveone.largestDigit(444));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void largestDigitTest_negativeNumber() {
		assertEquals(4, recursiveone.largestDigit(-1234));
	}
}
