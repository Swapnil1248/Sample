import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GamesCounter {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            BigInteger big = sc.nextBigInteger();
            int result = 0;
            big = big.subtract(BigInteger.ONE);
            System.out.println(big);
            while( big.compareTo(BigInteger.ZERO) > 0){
            	//System.out.println(big.compareTo(BigInteger.ZERO));            	
                big = big.and(big.subtract(BigInteger.ONE));
                System.out.println(big);
                result++;
            }
            if((result&1) > 0)
                System.out.println("Louise");
            else
                System.out.println("Richard");
        }
    }
}