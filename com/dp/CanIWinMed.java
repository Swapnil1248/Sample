package com.dp;
import java.util.*;
/**
 * Created by swapn on 12/24/2016.
 */
public class CanIWinMed {
    public static void main(String[] args){
        System.out.println(new CanIWinMed().canIWin(10,55));
    }
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal<=0) return true;
            if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
            HashMap<String, Boolean> hashMap = new LinkedHashMap<>();
            boolean val = canIWin(desiredTotal, new int[maxChoosableInteger], hashMap);
            return val;
        }
        private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
            String curr = Arrays.toString(state);
            if (hashMap.containsKey(curr)) return hashMap.get(curr);
            for (int i = 0; i < state.length; i++) {
                if (state[i] == 0) {
                    state[i] = 1;
                    if (total <= i + 1 || !canIWin(total - (i + 1), state, hashMap)) {
                        hashMap.put(curr, true);
                        state[i] = 0;
                        return true;
                    }
                    state[i] = 0;
                }
            }
            hashMap.put(curr, false);
            return false;
        }
}
