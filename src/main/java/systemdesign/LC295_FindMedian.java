package systemdesign;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by ruili1 on 8/27/17.
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 Examples:
 [2,3,4] , the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.
 For example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
 */
public class LC295_FindMedian {

    class MediumFinder {

        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MediumFinder() {
            min = new PriorityQueue<Integer>();
            max = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
        }

        public void addNum(int num){
            max.add(num);
            min.add(max.poll());
            if(max.size() < min.size()){
                max.add(min.poll());
            }
        }

        public double findMedian(){
            if(min.size() == max.size()){
                return ((double)min.peek() + (double)max.peek())/2;
            }else{
                return max.peek();
            }
        }

    }

    public static void main(String[] args){

        MediumFinder mediumFinder = new LC295_FindMedian().new MediumFinder();

        mediumFinder.addNum(5);
        mediumFinder.addNum(4);
        mediumFinder.addNum(3);
        mediumFinder.addNum(2);
//        mediumFinder.addNum(1);

        System.out.println(mediumFinder.findMedian());
    }
}
