package array;

import java.util.TreeMap;

/**
 * Created by ruili1 on 1/6/18.
 *
 *
 * Implement a MyCalendarThree class to store your events. A new event can always be added.

 Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

 A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)

 For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists a K-booking in the calendar.

 Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)
 Example 1:
 MyCalendarThree();
 MyCalendarThree.book(10, 20); // returns 1
 MyCalendarThree.book(50, 60); // returns 1
 MyCalendarThree.book(10, 40); // returns 2
 MyCalendarThree.book(5, 15); // returns 3
 MyCalendarThree.book(5, 10); // returns 3
 MyCalendarThree.book(25, 55); // returns 3
 Explanation:
 The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
 The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
 The remaining events cause the maximum K-booking to be only a 3-booking.
 Note that the last event locally causes a 2-booking, but the answer is still 3 because
 eg. [10, 20), [10, 40), and [5, 15) are still triple booked.
 Note:

 The number of calls to MyCalendarThree.book per test case will be at most 400.
 In calls to MyCalendarThree.book(start, end), start and end are integers in the range [0, 10^9].

 ------
 solution:
 use a treemap to manage a time line.
 For a start, increment its value on the timeline by 1.
 For an end, decrement its value on the timeline by 1.
 If two 1s appear before a -1 appear, it means there are two overlapped periods.
 After putting in all periods. Add up the values on the timelines and keep track of the max accumulation.

 */
public class LC732_CalendarIII {

    class MyCalendarThree {

        private TreeMap<Integer, Integer> timeline = null;

        public MyCalendarThree() {
            timeline =new TreeMap<Integer, Integer>();
        }

        public int book(int s, int e) {
            timeline.put(s, timeline.getOrDefault(s, 0) + 1); // 1 new event will be starting at [s]
            timeline.put(e, timeline.getOrDefault(e, 0) - 1); // 1 new event will be ending at [e];

            Utils.printMap(timeline);

            int ongoing = 0, k = 0;
            for (int v : timeline.values())
                k = Math.max(k, ongoing += v);
            return k;
        }
    }

    public static void main(String[] args){

        MyCalendarThree calendar = new LC732_CalendarIII().new MyCalendarThree();

        System.out.println(calendar.book(10, 20));// 1
        System.out.println(calendar.book(15, 30));// 2
        System.out.println(calendar.book(20, 20));// 2

    }
}
