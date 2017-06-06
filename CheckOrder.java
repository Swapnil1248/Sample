import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CheckOrder {
	public static void main(String[] args) {

		int a = (1 + ((2 - 3) * 4) / (5 % 6 << 7) >> (8) >>> 9) + 3;
		System.out.println(Math.log(243) / Math.log(3));
		System.out.println(new CheckOrder().isUgly(937351770));
	}

	public boolean isUgly(int num) {
		 if (num < 0) return false;
		if (num == 1)
			return true;
		boolean[] noPrime = sieve(Integer.MAX_VALUE);
		for(int i = 7; i < noPrime.length ; i++){
			if(noPrime[i] ==  false){
				if(num%i == 0){
					return true;
				} 
			}
		}
		return false;
	}

	private boolean[] sieve(int n) {
		boolean[] composite = new boolean[n];
		for (int i = 2; i <= n; i++) {
			if (!composite[i]) {
				for (int j = i; i*j <= n; j++) {
					composite[i*j] = true;
				}
			}
		}
		return composite;
	}

	public int majorityElement(int[] nums) {
		int cutoff = nums.length / 2;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == null) {
				map.put(nums[i], 1);
			} else {
				map.put(nums[i], map.get(nums[i]) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() > cutoff) {
				return e.getKey();
			}
		}
		return 0;
	}

	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n = n & n - 1;
			count++;
		}
		return count;
	}

}
