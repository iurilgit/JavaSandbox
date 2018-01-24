package matrix;

/**
 * Created by ruili1 on 12/16/17.
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. T
 * his matrix has the following properties:

 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 Given target = 5, return true.

 Given target = 20, return false.

 --------
 solution:
 starting from upper right corner.
 if matrix[i][j] == target, return true.
 if matrix[i][j] < target, the whole row is smaller, then i++
 if matrix[i][j] > target, the whole column is larger, then j--.
 if i or j goes out of boundary, then there is no match

 */
public class LC240_Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int height = matrix.length;
        int width = 0;
        if(height > 0) {
            width = matrix[0].length;
        }
        if(height == 0 || width == 0){
            return false;
        }

        int i = 0;
        int j = width-1;
        while((i >= 0 && i < height) && (j >= 0 && j < width)){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args){

        int[][] matrix = {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 20));
    }
}
