package com.string;

/**
 * Created by swapn on 12/31/2016.
 */
import java.util.*;
public class LongestValidParantheses {
    public static void main(String[] args){
        LongestValidParantheses l = new LongestValidParantheses();
        int res = l.longestValidParentheses("(()()))()()()");
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }
}
