package dp;

/**
 * Created by ruili1 on 10/6/17.
 */
public class LC198_HouseRobber {

    public static int maxGain(int[] nums){

        if(nums.length == 0){
            return 0;
        }

        int[] gains = new int[nums.length];

        if(nums.length >= 1){
            gains[0] = nums[0];
        }
        if(nums.length >= 2){
            gains[1] = Math.max(nums[0], nums[1]);
        }
        for(int i = 2; i < nums.length; i++){
            gains[i] = Math.max(gains[i-2] + nums[i], gains[i-1]);
        }

        return gains[nums.length-1];
    }

    public static void main(String[] args){

        int[] nums = {5, 9, 3, 7, 8, 6};

        System.out.println(maxGain(nums));
    }
}
