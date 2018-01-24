package systemdesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ruili1 on 10/15/17.
 */
public class LRUCache2 {

    Map<Integer, Integer> map = null;
    int capacity;

    /*
    * @param capacity: An integer
    */
    public LRUCache2(final int capacity) {

        map = new LinkedHashMap<Integer, Integer>(){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {

        map.put(key, value);
    }


    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {

        return map.getOrDefault(key, -1);
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println(cache.get(2)); // 1
        cache.set(4, 1);
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(2)); // 1

//        LRUCache cache = new LRUCache(3);
//        cache.set(1, 1);
//        cache.set(2, 2);
//        cache.set(3, 3);
//        cache.set(4, 4);
//        System.out.println(cache.get(4)); // 4
//        System.out.println(cache.get(3)); // 3
//        System.out.println(cache.get(2)); // 2
//        System.out.println(cache.get(1)); // -1
//        cache.set(5, 5);
//        System.out.println(cache.get(1)); // -1
//        System.out.println(cache.get(2)); // 2
//        System.out.println(cache.get(3)); // 3
//        System.out.println(cache.get(4)); // -1
//        System.out.println(cache.get(5)); // 5

    }
}