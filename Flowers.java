/* Sample program illustrating input/output methods */
import java.util.*;

class Flowers{
   public static void main( String args[] ){
      
// helpers for input/output      

      Scanner in = new Scanner(System.in);
      
      int N, K;
      N = in.nextInt();
      K = in.nextInt();
      
      int C[] = new int[N];
      int F[] = new int[K]; 
      for(int i=0; i<N; i++){
         C[i] = in.nextInt();
      }
      Arrays.sort(C); 
      int result = 0;
       for(int i = N-1; i >= 0;){
           for(int j = 0; j < K && i >=0; j++){
               result += (F[j] + 1) * C[i];
               F[j]++;
               i--;
           }
       }
      System.out.println( result );
      
   }
}
