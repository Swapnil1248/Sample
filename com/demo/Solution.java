package com.demo;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] line = br.readLine().split("\\s+");
		long M = Long.parseLong(line[0]);
		long N= Long.parseLong(line[1]);
		long Q = Long.parseLong(line[2]);
		line = br.readLine().split("\\s+");
		TreeMap<Long,Long> map = new TreeMap<Long,Long>();
		HashMap<Long, Long> actorToScene = new HashMap<Long,Long>();
		/*for(long i = 0; i < M; i++){
			map.put((long)i, (long)0);
		}*/
		for( long i = 0; i < N; i++){
			long x = Long.parseLong(line[(int) i]);
			actorToScene.put(i,x);
			if(map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put((long)i, (long)1);
		}
		for(int i = 0;i < Q; i++){
			line = br.readLine().split("\\s+");
			if(Long.parseLong(line[0]) == 1){
				long a = Long.parseLong(line[1]);
				long b = Long.parseLong(line[2]);
				long oldScene = actorToScene.get(a);
				if(map.get(oldScene) == null){
					map.put(oldScene,(long)-1);
				}
				else
				map.put(oldScene, map.get(oldScene) - 1);
				actorToScene.put(a,b);
				map.put(b, map.get(b) + 1);
			}
			else{
				long key = Long.parseLong(line[1]);
				long count = 0;
				for (Map.Entry<Long, Long> entry : map.entrySet())
				{
				   long a = entry.getValue();
				    if(a < key)
				    	count++;
				  
				}
				
				sb.append(count).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int indexOf(long[] a, long key) {
        int lo = 0;
        int hi = a.length - 1;
        if(key > a[hi]){
        	return a.length;
        }
        if(key < a[lo]){
        	return 0;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= key && (mid==1 || key > a[mid-1]))
            	return mid;
            if (key <= a[mid]) hi = mid - 1;
            else lo = mid + 1;	
        }
        return -1;
    }
}
