package Stream;
import java.util.*;
/**
 * Created by swapnil on 5/19/2017.
 */
public class KMP {

    public static void main(String[] args){
        String text = "AAAAAAABAABAAAAA";
        String pattern = "AABAA";
        KMP kmp = new KMP();
        kmp.findSubString(text, pattern);
    }

    private void findSubString(String text, String pattern){
        int[] lps = lpsArray(pattern);
        System.out.println(Arrays.toString(lps));
        int i = 0;
        int j = 0;
        while(i < text.length()){
//            System.out.println(i+" "+j);
            if(j == pattern.length()){
                System.out.println("Index "+(i-j));
                j = lps[j-1];
            }
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }

    // AABAA
    private int[] lpsArray(String pattern){
        int[] arr = new int[pattern.length()];
        int i = 1;
        int len = 0;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                arr[i++] = ++len;
            }else{
                if(len != 0){
                    len = arr[len-1];
                }else{
                    arr[i++] = len;
                }
            }
        }
        return arr;
    }
}