package Stream;
import java.util.*;
/**
 * Created by swapnil on 5/4/2017.
 */
public class NList {
    public static void main(String[] args) {
        int[][] a = {
                { 10, 160, 200, 500, 500 },
                { 4, 150, 160, 200, 500 },
                { 2, 160, 200, 202, 203 },
                { 3, 4, 5, 160, 200 },
                { 3, 150, 160, 200, 210 } };

        int n = a.length;
        int[] x = new int[n];

        for( ; x[0] < n; x[0]++ ) {
            int val = a[0][x[0]];
            boolean print = true;
            for( int i = 1; i < n; i++ ) {
                while (a[i][x[i]] < val && x[i] < n-1) x[i]++;
                if (a[i][x[i]] != val) print = false;
            }
            if (print) System.out.println(val);
            System.out.println(Arrays.toString(x));
        }
    }
}
