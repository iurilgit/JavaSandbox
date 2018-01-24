package array;

/**
 * Created by ruili1 on 9/15/17.
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.

 --
 Idea:
 1. Brute force (not implemented)
 2. Set left to be the left most bar. Set right to be the right most bar.
 If we move the higher bar inward, it won't make the area larger because the height is decided by the lower bar.
 So we always move the lower bar inward, hoping it gets higher thus the area will be larger.

 */
public class LC11_ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0; // initial max area
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])*(right-left));
            if(height[left] < height[right]) {
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args){

        int[] height = {1, 3, 4, 2, 5};

        long startTime = System.nanoTime();

        System.out.println(maxArea(height));

        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime)/1000000.0 + " ms");
    }
}
