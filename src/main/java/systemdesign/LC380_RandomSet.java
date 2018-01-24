package systemdesign;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruili1 on 8/27/17.
 *
 * Design a data structure that supports all following operations in average O(1) time.

 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 Example:

 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 2 is the only number in the set, getRandom always return 2.
 randomSet.getRandom();


 note: my solution is not correct. hashset access is not random. it's based on hash value. so the first one in the iterator is always the same.
 */
public class LC380_RandomSet {

    class RandomizedSet {

        Set<Integer> set = null;

        /** Initialize your data structure here. */
        public RandomizedSet() {

            set = new HashSet<Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            if(!set.contains(val)){
                set.add(val);
                return true;
            }else{
                return false;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if(set.contains(val)){
                set.remove(val);
                return true;
            }else{
                return false;
            }
        }

        /** Get a random element from the set. */
        public Integer getRandom() {

            if(!set.isEmpty()) {
                for (Integer x : set) {
                    return x;
                }
                return null;
            }else{
                return null;
            }
        }

        public void print(){

            System.out.println(set);
        }
    }

    public static void main(String[] args){

        RandomizedSet set = new LC380_RandomSet().new RandomizedSet();

        boolean ret = set.insert(1);
        System.out.println(ret);
        set.print();

        ret = set.remove(2);
        System.out.println(ret);
        set.print();

        ret = set.insert(2);
        System.out.println(ret);
        set.print();

        int val = set.getRandom();
        System.out.println(val);

        val = set.getRandom();
        System.out.println(val);

        val = set.getRandom();
        System.out.println(val);

        ret = set.remove(1);
        System.out.println(ret);
        set.print();

        ret = set.insert(2);
        System.out.println(ret);
        set.print();

        val = set.getRandom();
        System.out.println(val);
    }
}
