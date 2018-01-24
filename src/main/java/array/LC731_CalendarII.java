package array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ruili1 on 1/6/18.
 *
 Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

 Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

 A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)

 For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

 Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 Example 1:
 MyCalendar();
 MyCalendar.book(10, 20); // returns true
 MyCalendar.book(50, 60); // returns true
 MyCalendar.book(10, 40); // returns true
 MyCalendar.book(5, 15); // returns false
 MyCalendar.book(5, 10); // returns true
 MyCalendar.book(25, 55); // returns true
 Explanation:
 The first two events can be booked.  The third event can be double booked.
 The fourth event (5, 15) can't be booked, because it would result in a triple booking.
 The fifth event (5, 10) can be booked, as it does not use time 10 which is already double booked.
 The sixth event (25, 55) can be booked, as the time in [25, 40) will be double booked with the third event;
 the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
 Note:

 The number of calls to MyCalendar.book per test case will be at most 1000.
 In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].

 Notes:
 Similar to LC729_CalendarI, but it allows double booking and NOT allow triple booking

 ------
 solution:
 Use two tree maps, 1 to track all the overlapped periods (doubleBookedMap)
 1 to track all the non-overlapped periods.
 For a given new period, firstly check the doubleBookedMap. If it overlaps, return false.
 Otherwise, check ranges just like CalendarI, but need to update ranges and
 doubleBookedMap if there is an overlap.
 Be aware that after merging one region in the ranges,
 there could be another overlap with another period in it. So need to do the check multiple times until no more overlaps.

 */
public class LC731_CalendarII {

    class MyCalendarTwo{

        TreeMap<Integer, Integer> singleBookedMap = null;
        TreeMap<Integer, Integer> doubleBookedMap = null;

        public MyCalendarTwo() {
            singleBookedMap = new TreeMap<Integer, Integer>();
            doubleBookedMap = new TreeMap<Integer, Integer>();
        }

        public boolean book(int start, int end) {

            // if it already overlaps with entries in the double booked ranges, it's a triple book, return false
            if(checkDoubleBookMap(start, end) == false){
                return false;
            }

            while(true) {
                Integer floorKey = singleBookedMap.floorKey(start);
                if (floorKey != null && singleBookedMap.get(floorKey) > start) { // double booked

                    // update doubleBookMap with the overlap of the two periods
                    int doubleBookStart = start;
                    int doubleBookEnd = Math.min(end, singleBookedMap.get(floorKey));
                    doubleBookedMap.put(doubleBookStart, doubleBookEnd);

                    // update ranges with the union period of the two periods
                    start = floorKey;
                    end = Math.max(end, singleBookedMap.get(floorKey));
                    singleBookedMap.remove(floorKey);
                }else {
                    break;
                }
            }

            while(true) {
                Integer ceilingKey = singleBookedMap.ceilingKey(start);
                if (ceilingKey != null && ceilingKey < end) {
                    // update doubleBookMap with the overlap of the two periods
                    int doubleBookStart = ceilingKey;
                    int doubleBookEnd = Math.min(end, singleBookedMap.get(ceilingKey));
                    doubleBookedMap.put(doubleBookStart, doubleBookEnd);

                    // update ranges with the union period of the two periods
                    end = Math.max(end, singleBookedMap.get(ceilingKey));
                    singleBookedMap.remove(ceilingKey);
                } else {
                    break;
                }
            }

            singleBookedMap.put(start, end);

//            System.out.println("ranges:");
//            Utils.printMap(ranges);
//            System.out.println("doubleBookedMap:");
//            Utils.printMap(doubleBookedMap);
//            System.out.println("--------------");

            return true;
        }

        public boolean checkDoubleBookMap(int start, int end){

            Integer floorKey = doubleBookedMap.floorKey(start);
            if(floorKey != null && doubleBookedMap.get(floorKey) > start){
                return false;
            }

            Integer ceilingKey = doubleBookedMap.ceilingKey(start);
            if(ceilingKey != null && ceilingKey < end){
                return false;
            }

            return true;
        }
    }


    public static void constructTestCases(){

        String testCasesStr = "69,78],[81,86],[80,87],[58,66],[40,46],[81,88],[40,47],[18,25]," +
                "[52,59],[80,88],[58,63],[15,21],[79,87],[77,83],[9,14],[67,76],[39,44],[36,45]," +
                "[11,20],[61,69],[51,60],[49,57],[48,53],[2,8],[8,15],[49,57],[8,16],[42,51]," +
                "[94,100],[44,50],[1,9],[69,78],[47,53],[98,100],[56,62],[26,31],[3,9],[68,75]," +
                "[85,92],[52,57],[51,59],[18,26],[60,65],[92,99],[90,98],[89,97],[39,44],[31,39]," +
                "[90,96],[44,49],[44,49],[47,54],[24,32],[59,68],[29,34],[38,43],[3,8],[98,100]," +
                "[48,57],[19,24],[65,71],[20,29],[18,23],[67,76],[78,86],[43,48],[30,39],[49,56]," +
                "[48,56],[84,91],[13,18],[96,100],[31,36],[1,8],[90,97],[96,100],[20,28],[45,52],[1,6],[13,22";

        String solutionsStr = "true,true,true,true,true,false,true,true,true,false,false,true," +
                "false,false,true,true,false,false,false,true,false,true,false,true,true,false," +
                "false,false,true,false,true,false,false,true,false,true,false,false,false,false," +
                "false,false,false,false,true,false,false,true,false,false,false,false,true,false," +
                "false,false,false,false,false,false,false,false,false,false,false,false,false," +
                "false,false,false,false,false,false,false,false,false,false,false,false,false";

        String[] testCases = testCasesStr.split("\\],\\[");
        String[] solutions = solutionsStr.split(",");
        System.out.println(testCases.length);
        System.out.println(solutions.length);

        for(int i = 0; i < testCases.length; i++){
            String s = "System.out.println(calendar.book(" + testCases[i] + ")); // " + solutions[i];
            System.out.println(s);
        }
    }

    public static void main(String[] args){

//        constructTestCases();

        LC731_CalendarII.MyCalendarTwo calendar = new LC731_CalendarII().new MyCalendarTwo();
//
//        System.out.println(calendar.book(10, 20)); // returns true
//        System.out.println(calendar.book(50, 60)); // returns true
//        System.out.println(calendar.book(10, 40)); // returns true
//        System.out.println(calendar.book(5, 15)); // returns false
//        System.out.println(calendar.book(4, 10)); // returns true
//        System.out.println(calendar.book(25, 55)); // returns true

        System.out.println(calendar.book(69,78)); // true
        System.out.println(calendar.book(81,86)); // true
        System.out.println(calendar.book(80,87)); // true
        System.out.println(calendar.book(58,66)); // true
        System.out.println(calendar.book(40,46)); // true
        System.out.println(calendar.book(81,88)); // false
        System.out.println(calendar.book(40,47)); // true
        System.out.println(calendar.book(18,25)); // true
        System.out.println(calendar.book(52,59)); // true
        System.out.println(calendar.book(80,88)); // false
        System.out.println(calendar.book(58,63)); // false
        System.out.println(calendar.book(15,21)); // true
        System.out.println(calendar.book(79,87)); // false
        System.out.println(calendar.book(77,83)); // false
        System.out.println(calendar.book(9,14)); // true
        System.out.println(calendar.book(67,76)); // true
        System.out.println(calendar.book(39,44)); // false
        System.out.println(calendar.book(36,45)); // false
        System.out.println(calendar.book(11,20)); // false
        System.out.println(calendar.book(61,69)); // true
        System.out.println(calendar.book(51,60)); // false
        System.out.println(calendar.book(49,57)); // true
        System.out.println(calendar.book(48,53)); // false
        System.out.println(calendar.book(2,8)); // true
        System.out.println(calendar.book(8,15)); // true
        System.out.println(calendar.book(49,57)); // false
        System.out.println(calendar.book(8,16)); // false
        System.out.println(calendar.book(42,51)); // false
        System.out.println(calendar.book(94,100)); // true
        System.out.println(calendar.book(44,50)); // false
        System.out.println(calendar.book(1,9)); // true
        System.out.println(calendar.book(69,78)); // false
        System.out.println(calendar.book(47,53)); // false
        System.out.println(calendar.book(98,100)); // true
        System.out.println(calendar.book(56,62)); // false
        System.out.println(calendar.book(26,31)); // true
        System.out.println(calendar.book(3,9)); // false
        System.out.println(calendar.book(68,75)); // false
        System.out.println(calendar.book(85,92)); // false
        System.out.println(calendar.book(52,57)); // false
        System.out.println(calendar.book(51,59)); // false
        System.out.println(calendar.book(18,26)); // false
        System.out.println(calendar.book(60,65)); // false
        System.out.println(calendar.book(92,99)); // false
        System.out.println(calendar.book(90,98)); // true
        System.out.println(calendar.book(89,97)); // false
        System.out.println(calendar.book(39,44)); // false
        System.out.println(calendar.book(31,39)); // true
        System.out.println(calendar.book(90,96)); // false
        System.out.println(calendar.book(44,49)); // false
        System.out.println(calendar.book(44,49)); // false
        System.out.println(calendar.book(47,54)); // false
        System.out.println(calendar.book(24,32)); // true
        System.out.println(calendar.book(59,68)); // false
        System.out.println(calendar.book(29,34)); // false
        System.out.println(calendar.book(38,43)); // false
        System.out.println(calendar.book(3,8)); // false
        System.out.println(calendar.book(98,100)); // false
        System.out.println(calendar.book(48,57)); // false
        System.out.println(calendar.book(19,24)); // false
        System.out.println(calendar.book(65,71)); // false
        System.out.println(calendar.book(20,29)); // false
        System.out.println(calendar.book(18,23)); // false
        System.out.println(calendar.book(67,76)); // false
        System.out.println(calendar.book(78,86)); // false
        System.out.println(calendar.book(43,48)); // false
        System.out.println(calendar.book(30,39)); // false
        System.out.println(calendar.book(49,56)); // false
        System.out.println(calendar.book(48,56)); // false
        System.out.println(calendar.book(84,91)); // false
        System.out.println(calendar.book(13,18)); // false
        System.out.println(calendar.book(96,100)); // false


        System.out.println(calendar.book(31,36)); // false
        System.out.println(calendar.book(1,8)); // false
        System.out.println(calendar.book(90,97)); // false
        System.out.println(calendar.book(96,100)); // false
        System.out.println(calendar.book(20,28)); // false
        System.out.println(calendar.book(45,52)); // false
        System.out.println(calendar.book(1,6)); // false
        System.out.println(calendar.book(13,22)); // false

    }

}
