package hackerrank.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle
{

	public Triangle()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int acuteCount = 0;
		int obtuseCount = 0;
		int rightCount = 0;
		long A[] = new long[N];
		for (int A_i = 0; A_i < N; A_i++)
		{
			A[A_i] = in.nextLong();
		}
		//Arrays.sort(A);
		for (int i = 0; i < N - 2; ++i)
		{
			for (int j = i + 1; j < N; ++j)
			{
				int k = j + 1;
				while (k < N && A[i] + A[j] > A[k])
				{
					long c = A[k] * A[k];
					long a = A[i] * A[i];
					long b = A[j] * A[j];
					//System.out.println(A[k] + " = " + A[i] + " " + A[j]);
					if (c == a + b)
					{
						//System.out.println("Right");
						rightCount++;
					}
					else if (c < a + b)
					{
						//System.out.println("Acute");
						acuteCount++;
					}
					else
					{
						//System.out.println("Obtuse");
						obtuseCount++;
					}
					++k;
				}
			}
		}
		System.out.println(acuteCount + " " + rightCount + " " + obtuseCount);
	}

}
