package tdd;

import java.util.HashMap;
import java.util.Map.Entry;

public class StringCalculator {
	public static Integer calledCount = 0;
	public StringCalculator()
	{
		
	}

	public static void main(String[] args) throws Exception {
		StringCalculator sc = new StringCalculator();
		sc.add("//;\n1;3;4");
	}
	public static void incrementCalledCount() {
		calledCount++;
	}
	public int add(String s) throws Exception {
		incrementCalledCount();
		StringBuilder sb  = new StringBuilder(s);
		StringBuilder negativeNumbers = new StringBuilder();
		if(s.equals(""))
		{
			return 0;
		}
		String delimeter = "[\n ,]";
		
		if(s.startsWith("//["))
		{
			int index = sb.lastIndexOf("]");
			s = s.substring(index + 2, s.length());
			delimeter = getCustomDelimeter(sb);
		}
		else if(s.startsWith("//"))
		{
			delimeter = s.charAt(2)+"";
			s = s.substring(4 , s.length());
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

	public String getCustomDelimeter(StringBuilder sb)
	{
		int index = sb.lastIndexOf("]");
		HashMap<Character , Integer> map = new HashMap<Character, Integer>(); 
		for(int i=3 ; i < index ; i++)
		{
			char c = sb.charAt(i);
			if(c=='[' || c== ']')
			{
				continue;
			}
			map.put(c , map.getOrDefault(c , 0) + 1);
		}
		StringBuilder delimeter = new StringBuilder();
		for(Entry<Character , Integer> entry : map.entrySet())
		{
			char c = entry.getKey();
			int count = entry.getValue();
			delimeter.append("["+c+"]"+"{"+count+"}|");
		}
		delimeter.deleteCharAt(delimeter.length()-1);
		return delimeter.toString();
	}
	public Integer getCalledCount() {
		
		return calledCount;
	}

}
