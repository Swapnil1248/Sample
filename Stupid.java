import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Stupid {
	static int MAX_SIZE = 128;
	static int MAX_SUM = 2048;
	static long MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[MAX_SIZE];
		int m, r, s;
		long[][] f = new long[MAX_SIZE][MAX_SUM];

		int sa, sb;
		long res = 0;

		
		int[] array1 = new int[]{};
		int[] array2 = new int[4];
		
		m = sc.nextInt();
		r = sc.nextInt();
		s = sc.nextInt();
		sa = (r + s) / 2;
		sb = (r - s) / 2;
		for (int i = 0; i < m; i++)
			a[i] = sc.nextInt();

		f[0][0] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = m; j >= 1; j--) {
				for (int k = 2000; k >= 0; k--) {
					if (k >= a[i])
						f[j][k] = (f[j][k] + f[j - 1][k - a[i]]) % MOD;
				}
			}
		}

		for (int i = 1; i <= m; i++)
			res = (res + ((f[i][sa] % MOD) * (f[i][sb]% MOD)) % MOD) % MOD;

		System.out.println(res);
		
		demo d =  new demo();
		d.utr = 0;
	}
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> result = new ArrayList<>();
	        
	        if(candidates == null || candidates.length == 0) 
	            return result;
	        Arrays.sort(candidates);
	        ArrayList<Integer> current = new ArrayList<Integer>();
	        
	        combinationSum(candidates, target, 0, current, result);
	        HashSet<List<Integer>> set = new HashSet<>(result);
	 
	        result.clear();
	        result.addAll(set);
	        
	        return result;
	    }
	    
	    private void combinationSum(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result){
	        if(target == 0){
	            ArrayList<Integer> temp = new ArrayList<Integer>(current);
	            result.add(temp);
	            return;
	        }
	        
	        for(int i = index; i < candidates.length; i++){
	            if(target < candidates[i]) 
	                return;
	            
	            current.add(candidates[i]);
	            combinationSum(candidates, target - candidates[i], i+1, current, result);
	            current.remove(current.size() - 1 );
	        }
	    }

	private static class demo{
		public int utr;
	}

}
