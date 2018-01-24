package dp;

import array.Utils;

/**
 * Created by ruili1 on 12/16/17.
 *
 LC62: unique paths I
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?

 Note: m and n will be at most 100.

 LC63: extension of LC62
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.

 *
 * solution:
 * I: DP: solution[i][j] = solution[i-1][j] + solution[i][j-1]
 * II: same as I, but if obstacle[i][j] = 1, solution[i][j] = 0
 */
public class LC62_63_UniquePathsI_II {

    public static int uniquePaths(int m, int n) {

        int[][] solution = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 || j == 1){
                    solution[i][j] = 1;
                }else {
                    solution[i][j] = solution[i - 1][j] + solution[i][j - 1];
                }
            }
        }

        Utils.printMatrix(solution);

        return solution[m][n];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // get size of the grid
        int m = obstacleGrid.length;
        int n = 0;
        if(m > 0) {
           n = obstacleGrid[0].length;
        }
        if(m ==0 || n == 0){
            return 0;
        }

        int[][] solution = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    solution[i][j] = 0;
                    continue;
                }

                if(obstacleGrid[i-1][j-1] == 1){
                    solution[i][j] = 0;
                    continue;
                }

                if(i == 1 && j == 1){
                    solution[i][j] = 1;
                    continue;
                }

                solution[i][j] = solution[i - 1][j] + solution[i][j - 1];
            }
        }

        Utils.printMatrix(solution);

        return solution[m][n];
    }

    public static void main(String[] args){

        // for I
        System.out.println(uniquePaths(3, 3));

        // for II
//        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid = {{1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
