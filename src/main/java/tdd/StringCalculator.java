package tdd;

public class StringCalculator {
	public static Integer calledCount = 0;
	public StringCalculator()
	{
		
	}

	public static void incrementCalledCount() {
		calledCount++;
	}
	public int add(String s) throws Exception {
		incrementCalledCount();
		StringBuilder negativeNumbers = new StringBuilder();
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
			int number = Integer.parseInt(strs[i]);
			if(number < 0)
			{
				negativeNumbers.append(" ");
				negativeNumbers.append(number);
			}
			if(number > 1000)
			{
				continue;
			}
			sum += number;
		}
		if(!negativeNumbers.toString().equals(""))
		{
			throw new Exception("negatives not allowed:"+negativeNumbers);
		}
		return sum;
	}

	public Integer getCalledCount() {
		
		return calledCount;
	}

}
