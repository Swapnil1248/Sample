
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoPlus {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] boolArr;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] line = br.readLine().split("\\s+");
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);
            arr = new int[n][m];
            boolArr = new boolean[n][m];
            String ele = new String();
            boolean check = false;
            for(int i = 0; i < n; i++){
                ele = br.readLine();
                for(int j=0; j < m; j++){
                	boolArr[i][j] = false;
                    if(ele.charAt(j) == 'G'){
                        arr[i][j] = 1;
                        check = true;
                    }
                    else{
                        arr[i][j] = 0;
                        }
                }
            }
            //System.out.println(Arrays.deepToString(arr));
            if(check)
            System.out.println(solve());
            else
            	System.out.println(0);
        }
        catch(IOException e){
            
        }
    }
    
    public static int solve(){
    	int count  = 0;
    	int first = 0;
    	int second = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
            	count = 0;
                while(isValidPlus(i,j,count) && !isSeen(i,j)){
                	
                	count++;
                }   
                if(count>0){
                	second = Math.max(second,4*(count-1)+1);
                	if(second > first){
                		first = first + second;
                		second = first - second;
                		first = first - second;
                	}
            }
           }
        }
        return first*second;
    }
    
    public static void markSeen(int x, int y, int val){
    	boolArr[x][y] = true;
    	boolArr[x+val][y] = true;
    	boolArr[x-val][y] = true;
    	boolArr[x][y+val] = true;
    	boolArr[x][y-val] = true;
    }
    
    public static boolean isSeen(int x, int y){
    	return boolArr[x][y];
    }
    
    public static boolean isValidPlus(int x, int y, int val){
    	System.out.println("x "+x+" y "+y+" val "+val);
        return isValid(x,y) && isValid(x+val,y) && isValid(x-val,y) && isValid(x,y+val) && isValid(x,y-val);
    }
    
    public static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m && (arr[x][y] == 1);
    }
}