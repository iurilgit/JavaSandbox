import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruili1 on 8/25/17.
 *
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t
 * and the absolute difference between i and j is at most k.
 */
public class LC220_ContainDuplicateIII {

    private static long getId(int i, long w) {

        return (i >= 0)? (long)i/w : ((long)i+1)/w -1;
    }

    public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {

        if (t < 0) return false;

        Map<Long, Long> map = new HashMap<Long, Long>();

        for(int i = 0; i <nums.length; i++){

            long w = (long)t + 1;  // the width should be t + 1
            long key = getId(nums[i], w);
            if(map.containsKey(key)){
                return true;
            }else if(map.containsKey(key - 1) && Math.abs(map.get(key - 1) - nums[i]) <= t) {
                return true;
            }else if(map.containsKey(key + 1) && Math.abs(map.get(key + 1) - nums[i]) <= t) {
                return true;
            }
            map.put(key, (long)nums[i]);

            if( i >= k){
                map.remove(getId(nums[i-k], w));
            }
        }

        return false;
    }

    public static void main(String[] args){

        int[] nums ={1, 2};
        int k = 0;
        int t = 1;

        System.out.println(containsNearbyAlmostDuplicate2(nums, k, t));
    }
}
