package array;

import java.util.Stack;

/**
 * Created by ruili1 on 12/27/17.
 *
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 find the area of largest rectangle in the histogram.

 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.

 ----
 solution:
 Solution1: For each bar, find the max rectangle that it can expand to (into both directions).
 To find this, search both directions until we find the first bar that is lower than the current bar.
 For example, for bar 5 (index = 2), leftIdx = 1, rightIdx = 4.

 Solution2: Same idea as 1, but use a stack to make it more efficient.
 For each bar, if the first bar or it is higher than the previous bar, push in.
 For each bar, if it is a virtual bar (height = 0 to append to the end) or shorter than the previous bar,
 pop it until the top bar in stack is taller.
 */
public class LC84_LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        if(heights.length == 0){
            return 0;
        }

        int maxArea = 0;

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int tgtHeightIdx = stack.pop();
                int leftIdx = stack.isEmpty() ? -1 : stack.peek();
                int rightIdx = i;
                maxArea = Math.max(maxArea, (rightIdx - leftIdx - 1) * heights[tgtHeightIdx]);
            }
            stack.add(i);

//            System.out.println(stack);
        }

        return maxArea;
    }

    public static void main(String[] args){

        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
}
