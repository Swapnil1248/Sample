package Stream;
import java.util.*;
/**
 * Created by swapnil on 5/15/2017.
 */
public class ThreeSum {

    public static void main(String[] args){
        int[] arr = new int[]{3,4,4,1,2};
        int target = 6;
//        List<List<Integer>> result = TSum(arr, target);
//        System.out.println(result);
        System.out.println(repeatedNumber2(arr));
    }

    private static List<Integer> repeatedNumber2(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length;i++) {
            while (arr[i] > 0 && arr[i] < arr.length && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++){
            if(i+1 != arr[i]){
              list.add(arr[i]);
//                list.add(i+1);
            }
        }
        return list;
    }

    public static List<List<Integer>> TSum(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null) return result;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int j = 0;
            int k = arr.length-1;
            while(j < k){
                int tempSum = arr[i] + arr[j] + arr[k];
                if(tempSum == target){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[j]);
                    tempList.add(arr[k]);
                    result.add(tempList);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]) j++;
                    while(j < k && arr[k] == arr[k+1]) k--;
                }
                else if(tempSum > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}