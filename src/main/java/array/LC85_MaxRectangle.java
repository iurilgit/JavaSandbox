package array;

import java.util.Stack;

/**
 * Created by ruili1 on 12/28/17.
 *
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.

 ------
 solution:
 same concept as LC84, for each row, maintain a histogram that contains 1s in the current row.
 Then use LC84 on each histogram to find the max rectangle and update a global maxRectArea.
 */
public class LC85_MaxRectangle {

    public static int maximalRectangle(char[][] matrix) {

        int height = matrix.length;
        int width = 0;
        if(height > 0){
            width = matrix[0].length;
        }

        if(height == 0 || width == 0){
            return 0;
        }

        int maxRectArea = 0;
        int[] heights = new int[width];
        for(int j = 0; j < width; j++){
            heights[j] = matrix[0][j] == '1' ? 1:0;
        }
        maxRectArea = Math.max(maxRectArea, largestRectangleArea(heights));

        for(int i = 1; i < height; i++){
            for(int j = 0; j < width; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxRectArea = Math.max(maxRectArea, largestRectangleArea(heights));
        }

        return maxRectArea;
    }

    // same as LC84's solution
    private static int largestRectangleArea(int[] heights) {

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

//        char[][] matrix1 = {
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','0','1','1','1'},
//                {'1','0','0','1','0'}};
//        System.out.println(maximalRectangle(matrix1));

        char[][] matrix2 = {
                {'0','1'},
                {'1','0'}};
        System.out.println(maximalRectangle(matrix2));
    }
}
