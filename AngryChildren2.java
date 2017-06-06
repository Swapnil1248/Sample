import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AngryChildren2
{

	public AngryChildren2()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());
		Arrays.sort(arr);
		System.out.println(solve(arr, N, K));
	}

	public static long solve(long[] arr, int N, int K)
	{
		long result = 0;
		long minResult = Long.MAX_VALUE;
		long[] prefix = new long[N];
		prefix[0] = 0;
		for (int i = 1; i < N; i++)
		{
			prefix[i] = prefix[i - 1] + arr[i-1];
		}
		// long[] sample = new long[K];
		for (int t = 0; t < N - K + 1; t++)
		{
			result = 0;
			//System.out.println("------------------------------");
			int oldIndex = t;
			//System.out.println("oldIndex t "+oldIndex+" "+t);
			for (int i = K-1; i > 0; i--)
			{
				//System.out.println("arr["+(t+i)+"] "+arr[t+i]);
				//System.out.println(i+" * arr["+(t+i)+"] "+i*arr[t+i]);
				//System.out.println("prefix["+(t+i)+"] "+prefix[t+i]);
				result += i * arr[t+i] - prefix[t+i] + prefix[oldIndex];
			}
			
			minResult = Math.min(minResult, result);
			//System.out.println("result "+result);
			//System.out.println("minResult "+minResult);
			//System.out.println("------------------------------");
		}
		return minResult;
	}
}
