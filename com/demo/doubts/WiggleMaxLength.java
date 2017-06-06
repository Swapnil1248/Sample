package com.demo.doubts;
import java.util.*;
/**
 * Created by swapn on 12/28/2016.
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int k = 0;
        while(k < nums.length - 1 && nums[k] == nums[k+1]){
            k++;
        }
        int[] result = new int[nums.length];
        int index = 2;
        result[0] = nums[0];
        result[1] = nums[1];
        boolean increasing = nums[0] > nums[1];
        for(int i = k; k < nums.length-1; i++){
            if((increasing && nums[i] < nums[i+1]) || (!increasing && nums[i+1] > nums[i])){
                result[index++] = nums[i+1];
                increasing = !(increasing);
            }
        }
        System.out.println(Arrays.toString(result));
        return index;
    }
}
