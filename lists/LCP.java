package lists;

/**
 * Created by swapn on 12/31/2016.
 */
import java.util.*;
public class LCP {

    public static void main(String[] args){
        LCP lcp = new LCP();
        String ans = lcp.longestCommonPrefix(new String[]{"a", "cca", "cac"});
        System.out.print(ans);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String lcp = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(lcp) != 0){
                lcp = lcp.substring(0, lcp.length()-1);
            }
            i++;
        }
        return lcp;
    }
}
