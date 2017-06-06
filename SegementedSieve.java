import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SegementedSieve {

	static int[] arr = new int[100001];
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int N = sc.nextInt();
			int M = sc.nextInt();
			Set<Integer> setN = seive(N);
			Set<Integer> setM = seive(M);
			setM.removeAll(setN);
			System.out.println();
			for(Integer n : setM){
				System.out.print(n + " ");
			}
		}
	}
	
	public static Set<Integer> seive(int N){
		Set<Integer> result = new TreeSet<Integer>();
		for (int i = 2; i <= Math.sqrt(N); i++)
        	{
            	if (arr[i] == 0)
            	{
                	for (int j = i * i; j <= N; j += i)
                	{
                    	arr[j] = 1;
                	}
            	}
        	}
        return result;
	} 
}
