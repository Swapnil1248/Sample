package com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiThreading {

	public MultiThreading() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStreamReader istream = new InputStreamReader(System.in) ;
        BufferedReader bufRead = new BufferedReader(istream) ;
        System.out.println("Please Enter In Your First Name: ");
        
        String firstName;
		try {
			firstName = bufRead.readLine();
			System.out.println(firstName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		File file = new File("Document.txt");
		ReadFile(file);
	}
	
	private static void ReadFile(File file) {
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        // process the line.
		    	System.out.println(line);
		    }
		    // line is not visible here.
		}
		catch(Exception ex){
			ex.printStackTrace();
		} 
	}
}
