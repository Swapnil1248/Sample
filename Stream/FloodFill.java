package Stream;

import java.util.*;

/**
 * Created by swapnil on 5/10/2017.
 */
public class FloodFill {

    public static void main(String[] args){
        int[][] arr = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
        };
        printArray(arr);
        System.out.println("---------------------------------");
        bfs(arr, 4, 4, 0);
        printArray(arr);
        System.out.println("---------------------------------");
        bfs(arr, 4, 4, 1);
        printArray(arr);
    }

    public static void bfs(int[][] arr, int x, int y, int target){
        Queue<int[]> queue = new LinkedList<>();
        int prev = arr[x][y];
        if(prev == target) return;
        arr[x][y] = target;
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int temp_x = temp[0];
            int temp_y = temp[1];
            if(temp_x+1 < arr.length && arr[temp_x+1][temp_y] == prev){
                arr[temp_x+1][temp_y] = target;
                queue.offer(new int[]{temp_x+1, temp_y});
            }
            if(temp_x-1 >= 0 && arr[temp_x-1][temp_y] == prev){
                arr[temp_x-1][temp_y] = target;
                queue.offer(new int[]{temp_x-1, temp_y});
            }
            if(temp_y+1 < arr[0].length && arr[temp_x][temp_y+1] == prev){
                arr[temp_x][temp_y+1] = target;
                queue.offer(new int[]{temp_x, temp_y+1});
            }
            if(temp_y-1 >= 0 && arr[temp_x][temp_y-1] == prev){
                arr[temp_x][temp_y-1] = target;
                queue.offer(new int[]{temp_x, temp_y-1});
            }
        }
    }

    public static void printArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

}
