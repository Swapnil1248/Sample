package com.binarysearch;

public class BSearch {

    public int LowerBound(long A[], int K){
        int low , high , mid ;
        low = 0 ;
        high = A.length - 1;
        mid = (low + high) / 2;

        while(low <= high){
            mid = ( low + high ) / 2 ;
            if(A[mid] >= K && ( mid == 1 || A[mid-1] < K ))
                return mid ;
            else if(A[mid] >= K)
                high = mid - 1 ;
            else
                low = mid + 1 ;
        }
        return mid ;
    }

    public long LowerBoundAnother(long A[], int K){
        int low , high , mid ;
        low = 0 ;
        high = A.length - 1;
        mid = (low + high) / 2;

        while(low <= high){
            mid = ( low + high ) / 2 ;
            if(A[mid + 1] > K && ( mid == 1 || A[mid] <= K ))
                return mid ;
            else if(A[mid] <= K)
                low = mid ;
            else
                high = mid;
        }
        return mid ;
    }

    public long UpperBoundAnother(long A[], int K){
        int low , high , mid ;
        low = 0 ;
        high = A.length - 1;
        mid = (low + high) / 2;

        while(low <= high){
            mid = ( low + high ) / 2 ;
            if(A[mid - 1] < K && ( mid == 1 || A[mid] >= K ))
                return mid ;
            else if(A[mid] >= K)
                high = mid ;
            else
                low = mid;
        }
        return mid ;
    }



    public int UpperBound(long A[],int K){
        int low , high , mid ;
        low = 0 ;
        high = A.length - 1 ;
        mid = (low + high) / 2;
        while(low <= high){
            mid = ( low + high ) / 2 ; // finding middle element
            if(A[mid] > K && ( mid == 1 || A[mid-1] <= K )) // checking conditions for upperbound
                return mid ;
            else if(A[mid] > K) // answer should be in left part
                high = mid - 1 ;
            else                // answer should in right part if it exists
                low = mid + 1 ;
        }
        return mid ; // this will execute when there is no element in the given array which > K
    }

    public static void main(String[] args){
        long[] preArr = new long[32000];
        for(int i = 1; i < preArr.length; i++){
            preArr[i] = i*i;
        }

        BSearch bsearch = new BSearch();

        long low = bsearch.UpperBoundAnother(preArr, 2);
        long high = bsearch.LowerBoundAnother(preArr, 27);
        System.out.println(high +" "+ low);
    }
}
