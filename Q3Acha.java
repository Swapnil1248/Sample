import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q3Acha {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = in.nextInt();
		for (int tc = 1; tc <= T; tc++)
			new Q3Acha(tc, in, out);
		out.close();
	}

	int N;
	int[] nxt;
	ArrayList<Integer>[] children;

	int dfs(int i, int p, int d) {
		int res = d;
		for (int j : children[i])
			if (p != j)
				res = Math.max(res, dfs(j, i, d + 1));
		return res;
	}

	public Q3Acha(int tc, Scanner in, PrintWriter out) {
		N = in.nextInt();
		nxt = new int[N];
		for (int i = 0; i < N; i++)
			nxt[i] = in.nextInt() - 1;
		children = new ArrayList[N];
		for (int i = 0; i < N; i++)
			children[i] = new ArrayList<>();

		int res = 0;
		boolean[] seen = new boolean[N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(seen, false);
			int len = 0;
			int cur = i;
			while (!seen[cur]) {
				len++;
				seen[cur] = true;
				cur = nxt[cur];
			}

			if (cur == i)
				res = Math.max(res, len);
		}
		for (int i = 0; i < N; i++)
			children[nxt[i]].add(i);

		int rr = 0;
		for (int i = 0; i < N; i++)
			if (i < nxt[i] && i == nxt[nxt[i]])
				rr += dfs(i, nxt[i], 1) + dfs(nxt[i], i, 1);
		res = Math.max(res, rr);
		out.printf("Case #%d: %d%n", tc, res);
	}
}
