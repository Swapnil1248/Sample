package Stream;

/**
 * Created by swapnil on 5/14/2017.
 */
public class SearchLargest {

    public static void main(String[] args){
        int[] arr = new int[]{5,1,2,3,4};
        arr = new int[]{5,6,7,8,9,10,1,2,3};
        arr = new int[]{1,2,3};
        System.out.println(findHeighestNumber(arr));
    }

    private static int findHeighestNumber(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int ans = 0;
        while(low < high){
            int mid = low + (high-low)/2;
            System.out.println(low + " "+mid+" "+high);
            if(arr[mid] < arr[high]){
                high = mid;
            }else{
                ans = low;
                low = mid+1;
            }
        }
        System.out.println(arr[ans]);
        return arr[low];
    }

}
