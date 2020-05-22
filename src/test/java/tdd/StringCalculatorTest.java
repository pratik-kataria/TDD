package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;
	
	@Before
	public void setup()
	{
		stringCalculator = new StringCalculator();
	}
	@Test
	public void emptyStringTest() throws Exception
	{
		String s = "";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 0);
	}

	@Test
	public void simpleTest() throws Exception
	{
		String s = "1,2";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 3);
	}
	
	@Test
	public void newLineTest1() throws Exception
	{
		String s = "1\n2,3";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 6);
	}
	@Test
	public void newLineTest() throws Exception
	{
		String s = "10,20\n30";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 60);
	}
	@Test()
	public void customDelimeterTest() throws Exception
	{
		String s = "//;\n1;3;4";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 8);
	}
	@Test(expected = Exception.class)
	public void negativeNumberTest() throws Exception
	{
		String s = "//;\n1;-2;-3;-4;3";
		int returnedValue = stringCalculator.add(s);
		
	}
	
	@Test
	public void getCalledCountTest() throws Exception
	{
		Integer returnedValue = null;
		returnedValue = stringCalculator.getCalledCount();
		Assert.assertNotNull(returnedValue);
	}
	
	@Test
	public void ignoreGreaterNumbers() throws Exception
	{
		String s = "10,20\n1001";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 30);
	}
	
	@Test()
	public void multipleCharDelimeterTest() throws Exception
	{
		String s = "//[***]\n1***2***3";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 6);
	}
	
	@Test()
	public void multipleDelimetersTest() throws Exception
	{
		String s = "//[*][%]\n1*2%3";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 6);
	}
	
	@Test()
	public void multipleDelimetersWithMulipleCharactersTest() throws Exception
	{
		String s = "//[**][%%]\n1**2%%3";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 6);
	}
	
	
}
