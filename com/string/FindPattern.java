package com.string;

public class FindPattern
{

	public FindPattern()
	{
	}

	public static void main(String[] args)
	{
		String text = "Hello this is string";
		String pattern = "this";
		FindPattern fp = new FindPattern();
		int index = fp.findStringPattern(text, pattern);

		if (index == -1)
			System.out.println("Pattern not found");
		else{
			System.out.println("Pattern found at index " + index);
			System.out.println("Pattern "+pattern);
			System.out.println("Text -> "+fp.highlightPattern(text, pattern, index));
		}	
	}

	public String highlightPattern(String text, String pattern, int index)
	{
		return highlight(text.toCharArray(), pattern.toCharArray(), index);
	}
	
	private String highlight(char[] text, char[] pattern, int index)
	{
		char[] newText = new char[text.length + 2];
		int newTextIndex = 0;
		for(int i = 0; i < text.length; i++ )
		{
			if(index == i || i == index + pattern.length)
			{
				newText[newTextIndex ++] = '"';		
			}
			newText[newTextIndex] = text[i];
			newTextIndex ++;
		}
		return String.valueOf(newText);
	}

	public int findStringPattern(String text, String pattern)
	{
		char[] textArray = text.toCharArray();
		char[] patternArray = pattern.toCharArray();
		return findCharPattern(textArray, patternArray);
	}

	private int findCharPattern(char[] text, char[] pattern)
	{
		int textLength = text.length;
		int patternLength = pattern.length;

		int loopedPatternLength;
		for (int index = 0; index < (textLength - patternLength); index++)
		{
			loopedPatternLength = 0;
			while ((loopedPatternLength < patternLength) && (text[index + loopedPatternLength] == pattern[loopedPatternLength]))
			{
				loopedPatternLength++;
			}
			if (loopedPatternLength == patternLength)
				return index;
		}
		return -1;
	}

}
