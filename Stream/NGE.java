package Stream;
import java.util.*;
/**
 * Created by swapnil on 5/3/2017.
 */
public class NGE {

    public static void main(String[] args){
        int[] arr = new int[]{1,5,3,2,6,4};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int next = arr[i];
            while(!stack.isEmpty() && stack.peek() < next){
                System.out.println(stack.pop() +" "+next);
            }
            stack.push(next);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop() +" -1");
        }
    }
}
