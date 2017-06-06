package hackerrank.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class TwoArray
{

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int T = sc.nextInt();
	        while(T-- > 0){
	            int N = sc.nextInt();
	            int K = sc.nextInt();
	            int[] array1 = new int[N];
	            int[] array2 = new int[N];
	            for(int i=0;i<N;i++){array1[i]=sc.nextInt();}
	            for(int i=0;i<N;i++){array2[i]=sc.nextInt();}
	            Arrays.sort(array1);
	            Arrays.sort(array2);
	            int b=N-1;
	            for(int a=0;a<N; a++ ){
	                if(array1[a]+array2[b] < K){
	                    break;
	                }
	                b--;
	            }
	            if(b==-1){
	                System.out.println("YES");
	            }
	            else{
	                System.out.println("NO");
	            }
	        }
	    }
	}