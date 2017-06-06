package com.demo;

public class ThreadMain {
	public static void main(String[] args) {
		Thread1ForRead read1 = new Thread1ForRead("Personal_records.txt"); 
		Thread1ForRead read2 = new Thread1ForRead("Academic_records.txt");
		Thread thread1 = new Thread(read1);
		Thread thread2  = new Thread(read2);
		
		thread1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
	}
}
