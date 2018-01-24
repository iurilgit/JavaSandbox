package array;

import java.util.TreeMap;

/**
 * Created by ruili1 on 1/7/18.
 */
public class LC715_RangeModule {

    class RangeModule{

        TreeMap<Integer, Integer> map = null;

        public RangeModule() {

            map = new TreeMap<Integer, Integer>();
        }

        public void addRange(int left, int right) {

            while(true) {
                Integer floorKey = map.floorKey(left);
                if (floorKey != null && map.get(floorKey) > left) { // overlaps
                    // update ranges with the union period of the two ranges
                    left = floorKey;
                    right = Math.max(right, map.get(floorKey));
                    map.remove(floorKey);
                }else {
                    break;
                }
            }

            while(true) {
                Integer ceilingKey = map.ceilingKey(left);
                if (ceilingKey != null && ceilingKey <= right) {
                    // update ranges with the union period of the two ranges
                    right = Math.max(right, map.get(ceilingKey));
                    map.remove(ceilingKey);
                } else {
                    break;
                }
            }

            map.put(left, right);

            System.out.println("map:");
            Utils.printMap(map);
            System.out.println("--------");
        }

        // if the range starting from floorKey covers this range? if yes, return true, otherwise return false
        public boolean queryRange(int left, int right) {

            Integer floorKey = map.floorKey(left);
            return floorKey != null && map.get(floorKey) >= right;
        }

        public void removeRange(int left, int right) {

            while(true) {
                Integer floorKey = map.floorKey(left);
                if (floorKey != null && map.get(floorKey) > left) { // overlaps with the range pointed by floorKey
                    if (right < map.get(floorKey)) { // range pointed by floorKey covers this range completely so it breaks the current range into two
                        int left1 = floorKey;
                        int right1 = left;

                        int left2 = right;
                        int right2 = map.get(floorKey);

                        map.remove(floorKey);
                        if (left1 < right1) {
                            map.put(left1, right1);
                        }
                        if (left2 < right2) {
                            map.put(left2, right2);
                        }
                    } else {                          // range pointed by floorKey covers partial of this range, so it shortens the range pointed by floorKey
                        int left1 = floorKey;
                        int right1 = left;

                        map.remove(floorKey);
                        map.put(left1, right1);
                    }
                } else {
                    break;
                }
            }

            while(true){
                Integer ceilingKey = map.ceilingKey(left);
                if (ceilingKey != null && right > ceilingKey) {
                    if(right >= map.get(ceilingKey)) { // range pointed by ceilingKey is completely covered by this range, so remove it
                        map.remove(ceilingKey);
                    }else{
                        int left1 = right;
                        int right1 = map.get(ceilingKey);
                        map.remove(ceilingKey);
                        map.put(left1, right1);
                    }
                }else{
                    break;
                }
            }


            System.out.println("map:");
            Utils.printMap(map);
            System.out.println("--------");
        }
    }

    public static void main(String[] args){

        RangeModule rangeModule = new LC715_RangeModule().new RangeModule();
//        rangeModule.addRange(10, 20);
//        rangeModule.removeRange(14, 16);
//        System.out.println(rangeModule.queryRange(10, 14)); // true
//        System.out.println(rangeModule.queryRange(13, 15)); // false
//        System.out.println(rangeModule.queryRange(16, 17)); // true

        rangeModule.addRange(6, 8);
        rangeModule.removeRange(7, 8);
        rangeModule.removeRange(8, 9);
        rangeModule.addRange(8, 9);
        rangeModule.removeRange(1, 3);
        rangeModule.addRange(1, 8);
        System.out.println(rangeModule.queryRange(2, 4)); // true
        System.out.println(rangeModule.queryRange(2, 9)); // true
        System.out.println(rangeModule.queryRange(4, 6)); // true
    }
}
