package com.demo;

/**
 * Created by swapn on 9/24/2016.
 */
public class Palin {
    public boolean isPalindrome(String s) {
        s = getValidString(s);
        System.out.println(s);
        return checkPalindrome(s);
    }

    private String getValidString(String s){
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                sb.append((char)((c - 'A') + 'a'));
            }else if(c >= 'a' && c <= 'z'){
                sb.append(c);
            }else if(c >= '0' && c <= '9'){
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean checkPalindrome(String s){

        boolean result = true;
        char[] arr = s.toCharArray();
        for(int i = 0; i <= arr.length/2; i++){
            if(arr[i] != arr[arr.length - i - 1]){
                return false;
            }
        }
        return result;
    }
}
