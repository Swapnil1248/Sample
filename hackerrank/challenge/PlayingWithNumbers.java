package hackerrank.challenge;

import java.io.*;
import java.util.*;

public class PlayingWithNumbers {

    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            ) {
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] array = new int[n];
            for (int i = 0; i<n; i++) {
                array[i]=Integer.parseInt(line[i]);
            }
            Arrays.sort(array);

            // prefixSums[i] = sum of array[0] ... array[i]
            int[] prefixSums = new int[n];
            int prefixSum = 0;
            for (int i=0; i<n; i++) {
                prefixSum += array[i];
                prefixSums[i]=prefixSum;
            }

            int numQuries = Integer.parseInt(br.readLine());
            line = br.readLine().split(" ");

            long cumQ = 0;
            for (int i=0; i<numQuries; i++) {
                int q = Integer.parseInt(line[i]);
                cumQ += q;

                // section of array below -cumQ will be [0,...,m)
                // section of array above -cumQ will be [l,...,n)
                int m = binarySearchLastBelow(-cumQ, array)+1;
                int sumArrayBelow = (m==0) ? 0 : prefixSums[m-1];
                int numBelow = m;

                int l = binarySearchFirstAbove(-cumQ, array);
                int sumArrayAbove = prefixSums[n-1] - ((l==0)? 0 : prefixSums[l-1]);
                int numAbove = n-l;

                long sumAbs = (sumArrayAbove - sumArrayBelow)+ (numAbove - numBelow)*cumQ;
                pw.println(sumAbs);
            }


        } catch (IOException e) {
            throw new RuntimeException("Input parsing error");
        }
    }

    // find index of the last number below q, in the indices [start,end)
    // note this returns -1 if q <= everything in the array
    public static int binarySearchLastBelow(long q, int[] array) {
        int start = 0;
        int end = array.length;
        int firstOccurrence = -1;
        int pivot;
        while (start<end) {
            pivot = (start+end)/2;
            if (q == array[pivot]) {
                firstOccurrence = pivot;
                end = pivot;
            } else if (q < array[pivot]) {
                end = pivot;
            } else {
                start = pivot+1;
            }
        }

        if (firstOccurrence != -1) {
            return firstOccurrence-1;
        } else {
            return (start == array.length) ? start-1 : array[start] < q ? start : start-1;
        }
    }
    // find index of the last number below q, in the indices [start,end)
    // note this returns array.length if q >= everything in the array
    public static int binarySearchFirstAbove(long q, int[] array) {
        int start = 0;
        int end = array.length;
        int lastOccurrence = -1;
        int pivot;
        while (start<end) {
            pivot = (start+end)/2;
            if (q == array[pivot]) {
                lastOccurrence = pivot;
                start = pivot+1;
            } else if (q < array[pivot]) {
                end = pivot;
            } else {
                start = pivot+1;
            }
        }

        if (lastOccurrence != -1) {
            return lastOccurrence+1;
        } else {
            return (start==array.length || array[start] > q) ? start : start+1;
        }
    }


}