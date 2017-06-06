package Stream;

import java.util.*;

public class NRCS {

    public static void main(String[] args){
        String s = "abcadcacacaca";
        System.out.println(LongestSubstringKDistinct(s,1));
        System.out.println(LongestSubstringKDistinct(s,2));
        System.out.println(LongestSubstringKDistinct(s,4));
    }

    private static String LongestSubstringKDistinct(String s, int k){
        int begin  = 0;
        int end = 0;
        int start = 0;
        int len = 0;
        int counter = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if(map.get(s.charAt(end))==1){
                counter++;
            }
            end++;
            while(counter > k){
                map.put(s.charAt(begin), map.getOrDefault(s.charAt(begin),0) - 1);
                if(map.get(s.charAt(begin)) == 0){
                    counter--;
                }
                begin++;
            }
            if(end-begin > len){
                len = end - begin;
                start = begin;
            }
        }
        return s.substring(start, start+len);
    }
}
