package array;

import java.util.*;

/**
 * Created by ruili1 on 12/10/17.
 *
 * Given a collection of intervals, merge all overlapping intervals.

 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 ----
 solution:
 1. do the merge pairwise with with O(N*N) complexity
 2. sort the intervals (by the starting index in ascending order using customized comparator) and merge with the previous interval
 complexity = O(NlogN) + O(N) = O(NlogN)
 */
public class LC56_MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0){
            return res;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        Interval last = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(overlap(last, intervals.get(i))){
                last = merge(last, intervals.get(i));
            }else{
                res.add(last);
                last = intervals.get(i);
            }
        }

        res.add(last);

        return res;
    }

    private static boolean overlap(Interval first, Interval second){

        return (second.start <= first.end);
    }

    // first appears before second
    private static Interval merge(Interval first, Interval second){

        return new Interval(first.start, Math.max(first.end, second.end));
    }

    public static void main(String[] args){

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(2,6));

        List<Interval> intervalsMerged = merge(intervals);
        for(Interval interval : intervalsMerged){
            System.out.println(interval);
        }
    }
}
