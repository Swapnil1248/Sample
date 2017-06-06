package com.demo.doubts;

import java.util.Map;
import java.util.HashMap;

public class ValidationChecker {

	public ValidationChecker() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Map<String,String> channelName = new HashMap<String,String>();
		channelName.put("ChannelInfo","AX");				
		if(!channelName.isEmpty() && channelName.containsValue("AX")){
			System.out.println("HashMap contains value");
		}else{
			System.out.println("HashMap does not contains value");
		}
	}
	
	}


