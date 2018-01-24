package matrix;

import array.Utils;

/**
 * Created by ruili1 on 12/10/17.
 *
 * You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:
 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]

 -----------
 solution:
 First, rotate along x axis, then rotate along diagonal axis

 If the end goal is counter clock wise, fist rotate along y axis then diagonal axis
 */
public class LC48_RotateImage {

    public static void rotate(int[][] matrix) {
        // straightforward solution: define another matrix to store the rotated matrix

        int n = matrix.length;
        int[][] matrix2 = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int i2 = j;
                int j2 = n-1-i;
                matrix2[i2][j2] = matrix[i][j];
            }
        }

        // copy the new matrix over the old matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = matrix2[i][j];
            }
        }
    }

    public static void rotateInPlace(int[][] matrix) {
        // first rotate along x axis
//        [1, 2, 3]
//        [4, 5, 6]
//        [7, 8, 9]
//        into
//        [7, 8, 9]
//        [4, 5, 6]
//        [1, 2, 3]
//        then rotate along diagonal axis
//        [7, 4, 1]
//        [8, 5, 2]
//        [9, 6, 3]

        int n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }

//        Utils.printMatrix(matrix);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j > i) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }


    public static void main(String[] args){

//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16}};
        rotateInPlace(matrix);
        Utils.printMatrix(matrix);
    }
}
