package com.string;

/**
 * Created by swapn on 12/31/2016.
 */
import java.util.*;
public class NRCS {

    static int NO_OF_CHARS = 26;

    public static int lengthOfLongestSubstring(String str) {
        int n = str.length();
        if(n == 0) return 0;
        int[] visited = new int[NO_OF_CHARS];
        Arrays.fill(visited,-1);
        int max = 1;
        int currLen = 1;
        int prevIndex;
        int start = 0, finalStart = 0;

        visited[str.charAt(0)-'A'] = 0;

        for(int i=1;i<n;i++) {
            prevIndex = visited[str.charAt(i)-'A'];

            if(prevIndex== -1 || i-currLen > prevIndex)
                currLen++;
            else {
                if(currLen > max) {
                    max = currLen;
                    finalStart = start;
                }
                currLen = i - prevIndex;
                start = prevIndex + 1;
            }

            visited[str.charAt(i)-'A'] = i;
        }

        if(currLen > max) {
            max = currLen;
            finalStart = start;
        }

        System.out.print("\nSolution : ");
        System.out.println(str.substring(finalStart,finalStart+max));
        System.out.println();

        return max;

    }

    public static void main(String[] args) {
        String str = "WKEWKEA";

        System.out.println("String : " + str);

        System.out.println("\nans = " + lengthOfLongestSubstring(str));
    }
}
