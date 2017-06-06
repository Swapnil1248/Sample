package hackerrank.challenge;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class Emma {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        double range = 0;
        long totalSum = 0;
        // your code goes here
        if( t % 2 == 0){
            range = t/2;
            totalSum =(long) (range*(range + 2.0));
        }
        else
        {
            range = (t + 1)/2;
            System.out.println("Range "+ range);
            totalSum = (long) (range*(range + 1.0) - 1.0);
        }
         System.out.println(totalSum);
    }
}
