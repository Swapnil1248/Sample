package hackerrank.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle3
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int acuteCount = 0;
		int obtuseCount = 0;
		int rightCount = 0;
		List<Triplet> triplet =new ArrayList<Triplet>();
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
					triplet.add(new Triplet(A[i],A[j],A[k]));
					++k;
				}
			}
		}
		for(Triplet tri : triplet ){
			long c = (long)tri.getC() *(long) tri.getC();
			long a = (long)tri.getA() *(long) tri.getA();
			long b = (long)tri.getB() *(long) tri.getB();
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
		}
		System.out.println(acuteCount + " " + rightCount + " " + obtuseCount);
	}
}

class Triplet
{
   Long a;
   Long b;
   Long c;

   Triplet(Long a, Long b, Long c)
   {
    this.a = a;
    this.b = b;
    this.c = c;
   }

   Long getA(){ return a;}
   Long getB(){ return b;}
   Long getC(){ return c;}
}
