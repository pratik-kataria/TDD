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
	public void emptyStringTest()
	{
		String s = "";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 0);
	}

	@Test
	public void simpleTest()
	{
		String s = "1,2";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 3);
	}
	
	@Test
	public void newLineTest1()
	{
		String s = "1\n2,3";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 6);
	}
	@Test
	public void newLineTest()
	{
		String s = "10  ,20 \n 30";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 60);
	}
	
	@Test
	public void changeDelimeterTest()
	{
		String s = "//;\n1;2";
		int returnedValue = stringCalculator.add(s);
		Assert.assertEquals(returnedValue, 3);
	}
}
