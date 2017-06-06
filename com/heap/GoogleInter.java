package com.heap;

/**
 * Created by swapn on 10/19/2016.
 */

import java.util.*;

public class GoogleInter {
    private class numVal{
        int count;
        int num;

        public numVal(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, 1 + map.get(num));
            }else{
                map.put(num,1);
            }

        }


        PriorityQueue<numVal> queue = new PriorityQueue<numVal>(
                new Comparator<numVal>(){
                    public int compare(numVal a, numVal b){
                        return a.count - b.count;
                    }
                });

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new numVal(entry.getKey(), entry.getValue()));
        }

        while(k-- > 0){
            list.add(queue.poll().num);
        }
        return list;
    }
}