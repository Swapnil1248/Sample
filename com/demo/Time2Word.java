package com.demo;

import java.util.Scanner;

public class Time2Word
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int h = in.nextInt();
		int m = in.nextInt();
		String[] lessThanTwenty = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty" };
		if (m == 0){
			System.out.println(lessThanTwenty[h-1] +"o' clock");
		}
		else if (m == 1){
			System.out.println("one minute past "+lessThanTwenty[h-1]);
		}
		else if (m == 15){
			System.out.println("quarter past "+lessThanTwenty[h-1]);
		}
		else if (m ==30){
			System.out.println("half past "+lessThanTwenty[h-1]);
		}
		else if (m == 45){
			System.out.println("quarter to "+lessThanTwenty[h]);
		}
		else if (m == 59){
			System.out.println("one minute to "+lessThanTwenty[h]);
		}
		else if(m < 30){
			if (m >= 20){
				System.out.println("twenty "+lessThanTwenty[m%20 - 1]+ " minutes past "+lessThanTwenty[h-1]);
			}else{
				System.out.println(lessThanTwenty[m-1]+ " minutes past "+lessThanTwenty[h-1]);
			}
		}
		else if(m > 30){
			if(60 - m > 20 ){
				System.out.println("twenty "+lessThanTwenty[(60 - m)%20 - 1]+ " minutes to "+lessThanTwenty[h]);
			}else{
				System.out.println(lessThanTwenty[59 - m]+ " minutes to "+lessThanTwenty[h]);
			}
		}
	}
}
