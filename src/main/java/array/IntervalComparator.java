package array;

import java.util.Comparator;

/**
 * Created by ruili1 on 12/10/17.
 */
public class IntervalComparator implements Comparator<Interval> {

    public int compare(Interval x, Interval y){
        return x.start - y.start;
    }
}