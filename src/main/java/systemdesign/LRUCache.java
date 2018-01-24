package systemdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 10/14/17.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least recently used item
 before inserting a new item.

 */
public class LRUCache {

    class Entry{

        Integer value;
        long ts;

        public Entry(int value){

            this.value = value;
            updateTS();
        }

        public void updateTS(){

            ts = System.nanoTime();
        }
    }

    Map<Integer, LRUCache.Entry> map = null;
    int capacity;

    /*
    * @param capacity: An integer
    */
    public LRUCache(int capacity) {

        map = new HashMap<Integer, LRUCache.Entry>();
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {

        if(map.size() == capacity) {
            int k = findLRUKey();
            map.remove(k);
        }

        map.put(key, new Entry(value));
    }

    private int findLRUKey(){

        int leastRecentlyUsedKey = 0;
        long leastRecentlyUsedTS = Long.MAX_VALUE;

        for(int key : map.keySet()){
            long ts = map.get(key).ts;
            if(ts < leastRecentlyUsedTS) {
                leastRecentlyUsedTS = ts;
                leastRecentlyUsedKey = key;
            }
        }

        return leastRecentlyUsedKey;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }
        map.get(key).updateTS();
        return map.get(key).value;
    }

    public static void main(String[] args){

//        LRUCache cache = new LRUCache(2);
//        cache.set(2, 1);
//        cache.set(1, 1);
//        System.out.println(cache.get(2)); // 1
//        cache.set(4, 1);
//        System.out.println(cache.get(1)); // -1
//        System.out.println(cache.get(2)); // 1

        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        System.out.println(cache.get(4)); // 4
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(1)); // -1
        cache.set(5, 5);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 2
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // -1
        System.out.println(cache.get(5)); // 5

    }
}