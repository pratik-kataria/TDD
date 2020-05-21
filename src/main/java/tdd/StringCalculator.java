package tdd;

public class StringCalculator {
	
	public StringCalculator()
	{
		
	}

	public int add(String s) {
		if(s.equals(""))
		{
			return 0;
		}
		String[] strs = s.split(",");
		int sum = 0;
		for(int i=0 ; i<strs.length ; i++)
		{
			sum += Integer.parseInt(strs[i]);
		}
		
		return sum;
	}

}
