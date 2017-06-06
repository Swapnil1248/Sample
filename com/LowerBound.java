package com;

/**
 * Created by swapn on 7/10/2016.
 */
public class LowerBound {

        public int searchInsert(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while(low <= high){
                int mid = (high + low)/2 ;
                if(nums[mid] == target){
                    return mid;
                }
                else if(target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }

                if(low == high){
                    if(target > nums[high]){
                        return high + 1;
                    }
                    return high;
                }else if(low > high){
                    return low;
                }
            }

            return -1;
        }
    }
