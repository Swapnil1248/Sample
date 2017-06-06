package Stream;
import java.util.*;
/**
 * Created by swapnil on 5/17/2017.
 */
public class MedianFinder {
    // max queue is always larger or equal to min queue
    PriorityQueue<Integer> min = new PriorityQueue();
    PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());
    // Adds a number into the data structure.

    public static void main(String[] args){
        MedianFinder mf = new MedianFinder();
        for(int i = 1; i <= 5; i++){
            mf.addNum(i);
            System.out.println(mf.findMedian());
        }
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
        else return max.peek();
    }
}
