package com.demo;

/**
 * Created by swapn on 9/24/2016.
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
public class FirstUniqueChar {
    private class Pair{
        public int index;
        public int count;

        public Pair(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    public int firstUniqChar(String s) {
        int index  = -1;
        Map<Character, Pair> map = new HashMap<Character, Pair>();
        for(int i = 0 ; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.get(s.charAt(i)).count++;
            }else{
                map.put(s.charAt(i), new Pair(i,1));
            }
        }

        for(Entry<Character, Pair> m : map.entrySet()){
            if(m.getValue().count == 1){
                return m.getValue().index;
            }
        }

        return index;
    }
}