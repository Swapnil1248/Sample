package com.string;

/**
 * Created by swapn on 12/30/2016.
 */
import java.util.*;
public class BasicCalculator {
    public static void  main(String[] args){
       int res = new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(res);
    }

        public int calculate(String s) {
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int num = 0;
            int sign = 1;
            int res = 0;
            for(int i = 0; i < s.length(); i++){
                char c  = s.charAt(i);
                if(c == ' ') continue;
                if(c >= '0' && c <= '9'){
                    num = num*10 + (int)(c-'0');
                }
                else if(c == '+'){
                    res += num * sign;
                    num = 0;
                    sign = 1;
                }
                else if(c == '-'){
                    res += num * sign;
                    num = 0;
                    sign = -1;
                }
                else if(c == '('){
                    stack.push(res);
                    stack.push(sign);
                    res = 0;
                    sign = 1;
                }
                else if(c == ')'){
                    res += num * sign;
                    num = 0;
                    res *= stack.pop();
                    res += stack.pop();
                }

            }
            if(num != 0) res += num * sign;

            return res;

        }
    }
