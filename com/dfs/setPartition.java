package com.dfs;
import java.util.*;
/**
 * Created by swapn on 12/22/2016.
 */
public class setPartition {

    public static void main(String[] args){
        List<List<List<Integer>>> result = new setPartition().partition(4);
    }

    public List<List<List<Integer>>> partition(int n){
        List<List<List<Integer>>> result = new ArrayList<>();
        _partition(1, n, result, 1);
        return result;
    }

    private List<List<Integer>> _partition(int start, int end, List<List<List<Integer>>> result, int i){
        if(i >= end){
            return new ArrayList<>();
        }

        for(int j = start; j <= end; j++){

        }
return null;
    }
}
