import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WorldSprit2 {
	public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] line = br.readLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            int[] c = new int[n];
            int[] s = new int[m];
            line = br.readLine().split("\\s+");
            for(int i = 0; i< n; i++){
            	c[i] = i;
            }
            for(int i=0;i<m;i++){
                s[i] = Integer.parseInt(line[i]);
            }
            Arrays.sort(s);
            int maxDist = Integer.MIN_VALUE;
            int sCounter = 0;
            int nextCounter = 0;
            int res = 0;
            for(int i = 0; i < n; i++){
                nextCounter = sCounter + 1 < m ? sCounter + 1: sCounter;
                int res1 = Math.abs(c[i] - s[sCounter]);
                //System.out.println("res1 "+res1);
                int res2 = Math.abs(c[i] - s[nextCounter]);
                //System.out.println("res2 "+res2);
                if(res1 > res2){
                	res = res2;
                	sCounter++;
                }
                else{
                	res = res1;
                }
                
                //System.out.println("res "+res);
                if( res >= maxDist){
                    maxDist = res;
                } 
            }
            System.out.println(maxDist);
        }catch(IOException e){
            
        }
        
    }
}
