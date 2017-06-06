package Stream;

import java.util.*;

/**
 * Created by swapnil on 5/13/2017.
 */
public class Josephus {

    public static void main(String[] args){
        int n = 5;
        int k = 6;
        int start = 0;
        List<Integer> queue = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            queue.add(i);
        }
        int ans = 0;
        while(!queue.isEmpty()){
            int toRemove = (start + k-1)%queue.size();
            ans = queue.remove(toRemove);
            start = toRemove;
        }

    System.out.println((ans)+"---------------------"+josephus(n,k));
    }

    public static int josephus(int n, int k)
    {
        int ans = -1;
        if (n == 1)
            ans = 1;
        else
            ans = (josephus(n - 1, k) + k-1) % n+1;
        return ans;
    }
}
