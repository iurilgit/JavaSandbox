package matrix;

import array.Utils;

/**
 * Created by ruili1 on 12/16/17.
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?

-----------
 solution:
 1st scan: use the first row and first column to track the cols/rows with zeros
 2nd scan: check the first row/column. if a 0 is found, set the entire column/row to 0s.

 */
public class LC73_SetMatrixZeros {

    public static void setZeroes(int[][] matrix) {

        // for every element in the matrix, if it is 0, set the leading element in its corresponding row and column to be 0
        boolean hasZeroInFirstRow = false;
        boolean hasZeroInFirstColumn = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                    if(i == 0){
                        hasZeroInFirstRow = true;
                    }

                    if(j == 0){
                        hasZeroInFirstColumn = true;
                    }
                }
            }
        }

        Utils.printMatrix(matrix);

        // for every element in the matrix (except first row and first column),
        // check it's leading element in first row or column. If it's 0,
        // set current element to 0
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // handle the first row and first column based on whether they contain zeros
        if(hasZeroInFirstColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(hasZeroInFirstRow){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args){

        int[][] matrix = {{1, 3, 1}, {0, 0, 1}, {4, 2, 1}};
//        int[][] matrix = {{1}};
        System.out.println("before");
        Utils.printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("after");
        Utils.printMatrix(matrix);
    }
}

