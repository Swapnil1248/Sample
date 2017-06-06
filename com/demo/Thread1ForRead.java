package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;




public class Thread1ForRead implements Runnable{
	
	private String fName = null;
	
	Thread1ForRead(String fName){
		this.fName = fName;
	}
	
	public void run(){
		try{
			File file = new File(fName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			
			//Buffered reader accept only Reader so Reader can accept its sub classes also
			
			String lineOfFile;
			
			while((lineOfFile=br.readLine())!=null){
				System.out.println(lineOfFile);
				try{
					Thread.sleep(11);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			// no flush() method is required
			br.close();
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(String fName){
		System.out.println("Hey!!");
	}
}
