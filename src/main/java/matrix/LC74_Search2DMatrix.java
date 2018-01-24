package matrix;

import array.Utils;

/**
 * Created by ruili1 on 12/16/17.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.


 ---------
 solution:
 binary search. calculate the middle based on the number of the elements in the submatrix.
 recover row and column index from mid: mid/width, mid%width

 */
public class LC74_Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int height = matrix.length;
        int width = 0;
        if(height > 0) {
            width = matrix[0].length;
        }
        if(height == 0 || width == 0){
            return false;
        }

        int left = 0;
        int right = (height*width -1);
        while(left <= right){
            int mid = (left+right)/2;
            int i = mid/width;
            int j = mid%width;
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 3));
    }

}
