package hackerrank.challenge;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 
1
1
9339
9672
1
9420
1
1
9880
1
 
Another Input
1
8 1 2 3 4 5 6 3 4
 * */
public class TeamFormationOpti
{
	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
        Scanner myScan = new Scanner(System.in);
        //Scanner myScan = new Scanner(new FileReader("/media/swapnil/Local Disk/eclipsework/Demo/src/input.txt"));
        int T = myScan.nextInt();
        while(T--!=0) {
            int n = myScan.nextInt();
            if (n == 0) {
                System.out.println("0");
            } else {
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (int i = 0; i < n; i++) {
                    array.add(myScan.nextInt());
                }
                Collections.sort(array);
                HashMap<Integer, PriorityQueue<Integer>> sizes = new HashMap<Integer, PriorityQueue<Integer>>();
                for (Integer j : array) {
                    int size = getSize(sizes, j - 1);
                    addSize(sizes, j, size + 1);
                    System.out.println("-------------------------------------");
                    for (Entry<Integer, PriorityQueue<Integer>> s : sizes.entrySet()){
                    	
                    System.out.println(s.getKey() + " " + s.getValue().toString());
                    }
                }

                Integer result = null;
                for (PriorityQueue<Integer> q : sizes.values()) {
                    Integer s = q.peek();
                    if (s != null) {
                        if (result == null || result.compareTo(s) > 0) {
                            result = s;
                        }
                    }
                }
                System.out.println(result);

            }
        }
        long endTime   = System.currentTimeMillis();
		System.out.println("Time " + (endTime - startTime));
    }

    public static int getSize(HashMap<Integer, PriorityQueue<Integer>> q,int a){
        PriorityQueue<Integer> temp = q.get(a);
        if(temp==null || temp.peek()==null){
            return 0;
        }else{
            return temp.poll();
        }
    }

    public static void addSize(HashMap<Integer,PriorityQueue<Integer>> sizes, int key, int val ){
        PriorityQueue<Integer> queue = sizes.get(key);
        if(queue == null){
            queue = new PriorityQueue<Integer>();
            sizes.put(key,queue);
        }
        queue.add(val);
    }
}
