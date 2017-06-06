package Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swapnil on 4/28/2017.
 */
public class PeakElement {

    private static List<Integer> list;
    public static void main(String[] args){
        list = new ArrayList<>();
        int[] arr = new int[]{5,6,7,8,9,10,1,2,3};
        findPeak(arr, 0, arr.length-1);
        System.out.println(list.toString());
    }

    private static void findPeak(int[] arr, int low, int high){
        if(low > high) return;

        int mid = (high - low)/2 + low;
//        System.out.println(low +" "+mid+" "+high);
        if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length-1 || arr[mid] > arr[mid+1])){
            list.add(mid);
        }
        if(arr[mid] < arr[mid+1])
            findPeak(arr, mid+1, high);
        else
            findPeak(arr, low, mid-1);
    }
}
