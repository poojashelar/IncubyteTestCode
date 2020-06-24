package com.java.test;

import org.junit.Assert;
import org.junit.Test;
import com.java.resource.StringCalculator;

public class StringCalculatorTest {

	StringCalculator cal = new StringCalculator();

	@Test
	public void testCalculatorWithEmptyString() {
		Assert.assertEquals(-1, cal.Add(""));
		Assert.assertEquals(-1, cal.Add(" "));
	}

	@Test
	public void testCalculatorWithOneNumber() {
		Assert.assertEquals(100, cal.Add("100"));
	}

	@Test
	public void testCalculatorWithTwoNumbers() {
		Assert.assertEquals(4, cal.Add("1,3"));
	}

	@Test
	public void testCalculatorWithMultipleNumbers() {
		Assert.assertEquals(17, cal.Add("1,3,5,8"));
	}
	
	@Test
	public void testCalculatorWithnewLineDelimiter() {
		Assert.assertEquals(18, cal.Add("1\n3,6\n8"));
	}
	
	@Test
	public void testCalculatorWithOnlyDelimiters() {
		Assert.assertEquals(0, cal.Add(",\n"));
	}
	
	@Test
	public void testCalculatorWithOneNumberAndDelimiters() {
		Assert.assertEquals(2, cal.Add("2,\n"));
	}
}
