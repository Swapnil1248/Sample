package com.st;

public class Test
{


	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a = 9, b =9;
		Test t = new Test();
		Sub s1 = new Sub();
		Sum s2 = new Sum();
		s1.summation(a, b);
		s2.summation(a, b);
		System.out.println(Thread.currentThread().getStackTrace());
	}

}
class Sub {
	public int summation(int a, int b){
		return a+b;
	}
}

class Sum {
	public int summation(int a, int b){
		return a+b;
	}
}
