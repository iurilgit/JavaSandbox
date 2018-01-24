package systemdesign;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 10/10/17.
 *
 * mplement a memcache which support the following features:

 get(curtTime, key). Get the key's value, return 2147483647 if key does not exist.

 set(curtTime, key, value, ttl). Set the key-value pair in memcache with a time to live (ttl).
 The key will be valid from curtTime to curtTime + ttl - 1 and it will be expired after ttl seconds.
 if ttl is 0, the key lives forever until out of memory.

 delete(curtTime, key). Delete the key.

 incr(curtTime, key, delta). Increase the key's value by delta return the new value.
 Return 2147483647 if key does not exist.

 decr(curtTime, key, delta). Decrease the key's value by delta return the new value.
 Return 2147483647 if key does not exist.
 It's guaranteed that the input is given with increasingcurtTime.

 Have you met this question in a real interview? Yes
 Clarification
 Actually, a real memcache server will evict keys if memory is not sufficient,
 and it also supports variety of value types like string and integer.
 In our case, let's make it simple, we can assume that we have enough memory
 and all of the values are integers.

 Search "LRU" & "LFU" on google to get more information about how memcache evict data.

 Try the following problem to learn LRU cache:
 http://www.lintcode.com/problem/lru-cache

 Example
 get(1, 0)
 >> 2147483647
 set(2, 1, 1, 2)
 get(3, 1)
 >> 1
 get(4, 1)
 >> 2147483647
 incr(5, 1, 1)
 >> 2147483647
 set(6, 1, 3, 0)
 incr(7, 1, 1)
 >> 4
 decr(8, 1, 1)
 >> 3
 get(9, 1)
 >> 3
 delete(10, 1)
 get(11, 1)
 >> 2147483647
 incr(12, 1, 1)
 >> 2147483647
 */
public class Memcache {

    class Entry{

        public int value;
        public int expireTime;

        public Entry(int curtTime, int value ,int ttl){

            this.value = value;
            if(ttl == 0){
                this.expireTime = -1;
            }else {
                this.expireTime = curtTime + ttl;
            }
        }

        public boolean expired(int curtTime){

            return expireTime > 0 && expireTime <= curtTime;
        }
    }

    Map<Integer, Entry> map = null;

    public Memcache() {

        map = new HashMap<Integer, Entry>();
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: An integer
     */
    public int get(int curtTime, int key) {

        if(map.containsKey(key)){

            Entry entry = map.get(key);
            if(entry.expired(curtTime)){
                return Integer.MAX_VALUE;
            }else{
                return entry.value;
            }
        }else{
            return Integer.MAX_VALUE;
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param value: An integer
     * @param ttl: An integer
     * @return: nothing
     */
    public void set(int curtTime, int key, int value, int ttl) {

        Entry entry = new Entry(curtTime, value, ttl);
        map.put(key, entry);
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @return: nothing
     */
    public void delete(int curtTime, int key) {

        if(map.containsKey(key)){
            map.remove(key);
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int incr(int curtTime, int key, int delta) {

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            if(entry.expired(curtTime)){
                return Integer.MAX_VALUE;
            }
            entry.value += delta;
            // entry.ts = curtTime;

            map.put(key, entry);
            return entry.value;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    /*
     * @param curtTime: An integer
     * @param key: An integer
     * @param delta: An integer
     * @return: An integer
     */
    public int decr(int curtTime, int key, int delta) {

        if(map.containsKey(key)){
            Entry entry = map.get(key);
            if(entry.expired(curtTime)){
                return Integer.MAX_VALUE;
            }
            entry.value -= delta;
            // entry.ts = curtTime;

            map.put(key, entry);
            return entry.value;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args){

        Memcache cache = new Memcache();
        System.out.println(cache.get(1, 0));        // >> 2147483647

        cache.set(2, 1, 1, 2);
        System.out.println(cache.get(3, 1));        // >> 1
        System.out.println(cache.get(4, 1));        // >> 2147483647
        System.out.println(cache.incr(5, 1, 1));    // >> 2147483647
        cache.set(6, 1, 3, 0);
        System.out.println(cache.incr(7, 1, 1));    // >> 4
        System.out.println(cache.decr(8, 1, 1)) ;   // >> 3
        System.out.println(cache.get(9, 1));        // >> 3
        cache.delete(10, 1);
        System.out.println(cache.get(11, 1));       // >> 2147483647
        System.out.println(cache.incr(12, 1, 1));   // >> 2147483647
    }
}