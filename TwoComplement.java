import java.util.Scanner;

public class TwoComplement
{

	public static void main(String[] args)
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		for (int T = sc.nextInt(); T > 0; T--)
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			long answer = 0;
			if (A < 0)
			{
				answer += getBitSum(Math.ceil(Math.abs(A) - 1)) + Math.abs(A) * 32;
			}
			else
			{
				answer += getBitSum(A);
			}
			answer += getBitSum(B);
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	public static long getBitSum(double d)
	{
		return (long) (Math.ceil(d / 2) + Math.log10(d + 1));
	}
}