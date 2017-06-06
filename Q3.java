import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());

			for (int i = 1; i <= T; i++) {
				int ans = 0;
				int N = Integer.parseInt(br.readLine());
				HashMap<Integer, PriorityQueue<Integer>> arr = new HashMap<Integer, PriorityQueue<Integer>>();
				int[] bakar = new int[N];
				boolean[] used = new boolean[N];
				String[] line = br.readLine().split("\\s+");
				HashMap<Integer, PriorityQueue<Integer>> aMap = new HashMap<Integer, PriorityQueue<Integer>>();
				for (int j = 0; j < N; j++) {
					int val = Integer.parseInt(line[j]) - 1;
					bakar[j] = val;
					addSize(arr, j, val);

				}

				for (int j = 0; j < N; j++) {
					int val = bakar[j];
					addSize(aMap, val, j);
				}

				int currentIndex = 0;
				System.out.println(currentIndex);
				while (true) {
					if (arr.get(currentIndex) != null && !arr.get(currentIndex).isEmpty() && !used[arr.get(currentIndex).peek()]) {
						ans++;
						used[currentIndex] = true;
						currentIndex = arr.get(currentIndex).poll();

						System.out.println(currentIndex);
					} else {
						int kuchBhi = bakar[currentIndex];
						if (aMap.get(kuchBhi) == null || aMap.get(kuchBhi).isEmpty()) {
							break;
						} else {
							if (used[aMap.get(kuchBhi).peek()]) {
								aMap.get(kuchBhi).poll();
							} else {
								ans++;
								used[kuchBhi] = true;
								currentIndex = aMap.get(kuchBhi).poll();
								System.out.println(currentIndex);
							}
						}
					}
				}
				System.out.println("Case #" + i + ": " + ans);
			}
		} catch (IOException e) {
		}
	}

	public static void addSize(HashMap<Integer, PriorityQueue<Integer>> sizes, int key, int val) {
		PriorityQueue<Integer> queue = sizes.get(key);
		if (queue == null) {
			queue = new PriorityQueue<Integer>();
			sizes.put(key, queue);
		}
		queue.add(val);
	}
}
