package com.dp;

import java.io.IOException;
import java.math.BigInteger;

public class DP1{

    public static void main(String[] args) throws IOException{
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = br.readLine();
        String[] requiredInput = inputLine.split("\\s+");
        Long firstTerm = Long.parseLong(requiredInput[0]);
        Long secondTerm = Long.parseLong(requiredInput[1]);
        int nthTerm = Integer.parseInt(requiredInput[2]);
        System.out.println(recFunction(firstTerm, secondTerm, nthTerm));*/
    	BigInteger output = recFunction((long)0, (long)1, 10);
        System.out.println(output);
    }
    
    public static BigInteger recFunction(long first, long second, int nthTerm){
    	BigInteger n1 = BigInteger.valueOf(first);
    	BigInteger n2 = BigInteger.valueOf(second);
    	BigInteger current = n1.add(n2.pow(2));
        for (int i = 3; i <= nthTerm; i++) {
            current = n1.add(n2.pow(2));
            //System.out.println(current+"="+n1+"+"+n2+"*"+n2);
            n1 = n2;
            n2 = current;
        }
    return current;
    } 
}