package array;

/**
 * Created by ruili1 on 9/19/17.
 *
 * Given n non-negative integers representing an elevation ranges where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 The above elevation ranges is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.

 */
public class LC42_TrappingRainWater {

    public static int trap(int[] heights) {

        int len = heights.length;

        // find the max height and its idx
        int maxHeight = 0;
        int maxHeightIdx = -1;
        for(int i = 0; i < len; i++){
            if(heights[i] > maxHeight){
                maxHeight = heights[i];
                maxHeightIdx = i;
            }
        }

        int totalWaterTrapped = 0;

        // calculate water trapped to the left of the highest bar
        int leftWallHeight = 0;
        int rightWallHeight = maxHeight;
        for(int i = 0; i < maxHeightIdx; i++){
            int currWater = Math.min(leftWallHeight, rightWallHeight) - heights[i];
            if(currWater > 0){
                totalWaterTrapped += currWater;
                leftWallHeight = heights[i] + currWater;
            }else{
                leftWallHeight = heights[i];
            }
        }

        // calculate water trapped to the right of the highest bar
        leftWallHeight = maxHeight;
        rightWallHeight = 0;
        for(int i = len -1; i > maxHeightIdx; i--){
            int currWater = Math.min(leftWallHeight, rightWallHeight) - heights[i];
            if(currWater > 0){
                totalWaterTrapped += currWater;
                rightWallHeight = heights[i] + currWater;
            }else{
                rightWallHeight = heights[i];
            }
        }

        return totalWaterTrapped;
    }

    public static void main(String[] args){

        int[] heights =  {2, 1, 2}; //{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

}
