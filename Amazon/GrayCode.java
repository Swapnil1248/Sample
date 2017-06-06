package Amazon;

/**
 * Created by swapn on 12/21/2016.
 */
public class GrayCode {

    public boolean neigh(int a, int b){
        int x = a ^ b;
        int count = 0;
        while(x != 0){
            x = x & (x-1);
            count++;
        }
        return count == 1;
    }

    public boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
    }
}
