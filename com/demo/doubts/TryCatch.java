package com.demo.doubts;

public class TryCatch {

	public TryCatch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s =  null;
		try{
			s = new String("Hello");
			throw new Exception("fdkjnkj");
		}
		catch(Exception e){
			System.out.println("Message is "+e.getMessage());
			System.out.println("S is "+s);
		}
		finally{
			System.out.println("S is "+s);
		}
		
	}

}
