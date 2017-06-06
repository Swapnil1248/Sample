package lists;

import java.util.*;
/**
 * Created by swapn on 11/3/2016.
 */
public class ReverseArrayUsingList {

    public static void main(String[] args){
        reverse3(new Integer[]{1,2,3});
    }
    public static int[] reverse3(Integer[] nums) {
        //System.out.print(Arrays.asList(nums).toString());
        List<Integer> list1 = new ArrayList<>(Arrays.asList(nums));//Arrays.asList(nums);
        System.out.println(list1);
        Collections.reverse(list1);
        System.out.println(list1);
        return new  int[1];
    }
}
