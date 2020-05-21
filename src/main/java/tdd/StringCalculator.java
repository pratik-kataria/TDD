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
		String delimeter = "[\n ,]";
		if(s.startsWith("//"))
		{
			delimeter = s.charAt(2)+"";
			s = s.substring(5 , s.length() + 1);
		}
	
		String[] strs = s.split(delimeter);
		int sum = 0;
		for(int i=0 ; i<strs.length ; i++)
		{
			sum += Integer.parseInt(strs[i]);
		}
		
		return sum;
	}

}
