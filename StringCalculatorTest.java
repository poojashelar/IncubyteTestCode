package com.java.test;

import org.junit.Assert;
import org.junit.Test;
import com.java.resource.StringCalculator;

public class StringCalculatorTest {

	StringCalculator cal = new StringCalculator();

	@Test
	public final void testCalculatorWithEmptyString() {
		Assert.assertEquals(-1, cal.Add(""));
		Assert.assertEquals(-1, cal.Add(" "));
	}

	@Test
	public final void testCalculatorWithOneNumber() {
		Assert.assertEquals(100, cal.Add("100"));
	}

	@Test
	public final void testCalculatorWithTwoNumbers() {
		Assert.assertEquals(4, cal.Add("1,3"));
	}

	@Test
	public final void testCalculatorWithMultipleNumbers() {
		Assert.assertEquals(17, cal.Add("1,3,5,8"));
	}
	
	@Test
	public void testCalculatorWithnewLineDelimiter() {
		Assert.assertEquals(1+3+6+8, cal.Add("1\n3,6\n8"));
	}
	
	@Test
	public final void testCalculatorWithOnlyDelimiters() {
		Assert.assertEquals(0, cal.Add(",\n"));
	}
	
	@Test
	public final void testCalculatorWithOneNumberAndDelimiters() {
		Assert.assertEquals(2, cal.Add("2,\n"));
	}
	
	@Test
	public final void testCalculatorWhenStringStartWithDelimiters() {
		Assert.assertEquals(3, cal.Add("//;\n1;2"));
	}
	
	@Test(expected = RuntimeException.class)
	public final void TestCalculatorWhenNegativeNumbersUsedThrowException() {
	    cal.Add("2,5,78,-1,9");
	}
	
	@Test
	public final void TestCalculatorWhenNegativeNumbersUsed() {
		RuntimeException exception = null;
		try {
			cal.Add("2,-6,8,-3,56");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -3]", exception.getMessage());
	}

	@Test
	public final void TestCalculatorWhenNumbersAreGreaterThan1000IsUsedThenNotIncludeInSum() {
		Assert.assertEquals(15 + 1000 + 96 + 124, cal.Add("15,1000,1071,96,124"));
	}
	
	@Test
	public final void TestCalculatorWhenMultipleDelimitersWithBracketFormat() {
		Assert.assertEquals(1+2+3, cal.Add("//[***]\n1***2***3"));

	}
	
	@Test
	public final void TestCalculatorWhenMultipleDelimitersWithSpecialFormat() {
		Assert.assertEquals(1+2+3, cal.Add("//[*][%]\n1***2***3"));

	}
	
	@Test
	public final void TestCalculatorWhenMultipleDelimitersInMultipleBracketFormat() {
		Assert.assertEquals(1+2+3, cal.Add("//[***][%%%]\n1***2***3"));

	}
	
}
