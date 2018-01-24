package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ruili1 on 12/10/17.
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

 ------
 solution:
 Linear scanning from left to end, find the first interval that overlaps or is the first none overlap to the target index.
 Return that index: indexToInsert.

 copy all the intervals before that to the result.
 try merge intervals starting from indexToInsert until no more merge to newInterval, then insert newInterval to the end of result
 copy the rest of the intervals to the result

 */
public class LC57_InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0){ // if the list of intervals is empty, insert newInterval and return
            res.add(newInterval);
            return res;
        }

        // find the interval that is to the left of the target interval (linear)
        int indexToInsert = intervals.size();
        boolean overlap = false;
        for(int i = 0; i < intervals.size(); i++){
            if(intervals.get(i).start > newInterval.end){
                indexToInsert = i;
                break;
            }

            if(overlap(intervals.get(i), newInterval)){
                indexToInsert = i;
                overlap = true;
                break;
            }
        }
        System.out.println(indexToInsert);

        if(indexToInsert > 0) {
            res.addAll(intervals.subList(0, indexToInsert));
        }
        int i;
        for(i = indexToInsert; i < intervals.size(); i++){
            if(overlap(intervals.get(i), newInterval)){
                newInterval = merge(intervals.get(i), newInterval);
            }else{
                break;
            }
        }
        res.add(newInterval);
        res.addAll(intervals.subList(i, intervals.size()));

        return res;
    }

    private static boolean overlap(Interval x, Interval y){

        return Math.max(x.start, y.start) <= Math.min(x.end, y.end);
    }

    private static Interval merge(Interval x, Interval y){

        return new Interval(Math.min(x.start, y.start), Math.max(x.end, y.end));
    }

    public static void main(String[] args){

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,4));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
//        intervals.add(new Interval(2,5));

        List<Interval> intervalsMerged = insert(intervals, new Interval(17, 18));
        for(Interval interval : intervalsMerged){
            System.out.println(interval);
        }

    }
}
