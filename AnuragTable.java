/**
 * Created by swapn on 7/3/2016.
 */
import java.io.*;
import java.util.*;

class AnuragTable {
    public static void main (String[] args) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(10);
        temp.add(50);
        map.put(1, temp);
        ArrayList<Integer> temp2 = new ArrayList<Integer>();
        temp2.add(21);
        temp2.add(40);
        map.put(2, temp2);
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer,ArrayList<Integer>> val : map.entrySet()){

            if(result.containsKey(val.getKey())){
               // result.put(val.getKey(),result.get(val.getKey()) + val.getValue());
            }
            else {
               // result.put(val.getKey(), val.getValue());
            }
        }
    }
}