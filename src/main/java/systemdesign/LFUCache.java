package systemdesign;

import java.util.*;

/**
 * Created by ruili1 on 10/14/17.
 *
 * LFU (Least Frequently Used) is a famous cache eviction algorithm.

 For a cache with capacity k, if the cache is full and need to evict a key in it,
 the key with the lease frequently used will be kicked out.

 Implement set and get method for LFU cache.
 */
public class LFUCache {

    class Entry{

        Integer value;
        Integer count;
        long ts;

        public Entry(int value){

            this.value = value;
            this.count = 0;
            ts = System.currentTimeMillis();
        }

        public void incrementCount(){

            count++;
        }
    }

    Map<Integer, Entry> map = null;
    int capacity;

    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {

        map = new HashMap<Integer, Entry>();
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

        int leastFrequentlyUsedKey = 0;
        int leastCount = Integer.MAX_VALUE;

        for(int key : map.keySet()){
            int count = map.get(key).count;
            long ts = map.get(key).ts;
            if(count < leastCount ||
              (count == leastCount && map.get(key).ts < map.get(leastFrequentlyUsedKey).ts)) {
                leastCount = count;
                leastFrequentlyUsedKey = key;
            }
        }

        return leastFrequentlyUsedKey;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {

        if(!map.containsKey(key)){
            return -1;
        }
        map.get(key).incrementCount();
        return map.get(key).value;
    }

    public static void main(String[] args){

//        LFUCache cache = new LFUCache(3);
//        cache.set(2, 2);
//        cache.set(1, 1);
//        System.out.println(cache.get(2)); // 2
//        System.out.println(cache.get(1)); // 1
//        System.out.println(cache.get(2)); // 2
//        cache.set(3, 3);
//        cache.set(4, 4);
//        System.out.println(cache.get(3)); // -1
//        System.out.println(cache.get(2)); // 2
//        System.out.println(cache.get(1)); // 1
//        System.out.println(cache.get(4)); // 4

        LFUCache cache = new LFUCache(3);
        cache.set(1,10);
        cache.set(2,20);
        cache.set(3,30);
        System.out.println(cache.get(1)); // 10
        cache.set(4,40);
        System.out.println(cache.get(4)); // 40
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(1)); // 10
        cache.set(5,50);
        System.out.println(cache.get(1)); // 10
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // -1
        System.out.println(cache.get(5)); // 50

    }
}