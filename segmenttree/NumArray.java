package segmenttree;

/**
 * Created by swapn on 1/2/2017.
 */
import java.util.*;
public class NumArray {

    int[] segmentArray;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        int height = (int) (Math.ceil(Math.log(nums.length) / Math.log(2)));
        segmentArray = new int[2 * (int) Math.pow(2, height) - 1];
        buildArray(nums);
    }

    private void buildArray(int[] nums) {
        buildArray(nums, 0, n - 1, 0);
    }

    private int buildArray(int[] nums, int start, int end, int index) {
        if (start == end) {
            segmentArray[index] = nums[start];
            return segmentArray[index];
        }
        int mid = (end - start) / 2 + start;
        segmentArray[2*index+1] = buildArray(nums, start, mid, 2 * index + 1);
        segmentArray[2*index+2] = buildArray(nums, mid + 1, end, 2 * index + 2);
        segmentArray[index] = segmentArray[2*index+1] + segmentArray[2*index+2];

        return segmentArray[index];
    }

    private void update(int start, int end, int pos, int val, int index) {
        if (start == end) {
            segmentArray[index] = val;
        } else {
            int mid = start + (end - start) / 2;
            if (pos <= mid) {
                update(start, mid, pos, val, 2 * index + 1);
            } else {
                update(mid + 1, end, pos, val, 2 * index + 2);
            }
            segmentArray[index] = segmentArray[2 * index + 1] + segmentArray[2 * index + 2];
        }
    }


    void update(int i, int val) {
        update(0, n - 1, i, val, 0);
    }

    private int sumRange(int start, int end, int qs, int qe, int index) {
        if (start == qs && end == qe) {
            return segmentArray[index];
        }
        if(start == end) return segmentArray[index];
        int mid = start + (end - start) / 2;
        if (qe <= mid) {
            return sumRange(start, mid, qs, qe, 2 * index + 1);
        } else if (qs >= mid + 1) {
            return sumRange(mid + 1, end, qs, qe, 2 * index + 2);
        } else {
            return sumRange(start, mid, qs, qe, 2 * index + 1) + sumRange(mid + 1, end, qs, qe, 2 * index + 2);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(0, n - 1, i, j, 0);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println(Arrays.toString(numArray.segmentArray));
        System.out.println(numArray.sumRange(1, 2));
    }

   // [-28,-39,53,65,11,-56,-65,-39,-43,97],sumRange(5,6),update(9,27),sumRange(2,3),sumRange(6,7),update(1,-82),update(3,-72),sumRange(3,7),sumRange(1,8),update(5,13),update(4,-67)//
}
