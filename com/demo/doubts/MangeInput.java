package com.demo.doubts;

public class MangeInput {

	public MangeInput() {
	}
	public static void main(String []args){
		// TODO Auto-generated constructor stub
		int limit = 99;
		int actual = 999999999;
		long startTime = System.currentTimeMillis();
		useWhile(limit,actual);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println(elapsedTime);
	    System.out.println("*****************************************************");
	    startTime = System.currentTimeMillis();
	    useWhile(limit,actual);
	    elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println(elapsedTime);
	}

	private static void useWhile(int limit, int actual) {
		while (actual > limit) {
			actual-=limit;
			//System.out.println("Process " + limit);
		}
		//System.out.println("Process " + actual);
	}

	private static void useRecursion(int limit, int actual) {
		if (actual > limit) {
			actual -= limit;
			//System.out.println("Process " + limit);
			useRecursion(limit, actual);
		} else {
			//System.out.println("Process " + actual);
		}
	}
}
