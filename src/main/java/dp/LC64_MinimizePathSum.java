package dp;

import array.Utils;

/**
 * Created by ruili1 on 12/16/17.
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example 1:
 [[1,3,1],
 [1,5,1],
 [4,2,1]]
 Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

 ----------
 solution:
 similar as LC62_63, using DP, except the boundary values (i = 0 or j = 0) are initialized to be Integer.MAX_VALUE

 */
public class LC64_MinimizePathSum {

    public static int minPathSum(int[][] grid) {

        // get size of the grid
        int m = grid.length;
        int n = 0;
        if(m > 0) {
            n = grid[0].length;
        }
        if(m ==0 || n == 0){
            return 0;
        }

        int[][] pathLens = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    pathLens[i][j] = Integer.MAX_VALUE;
                    continue;
                }

                if(i == 1 && j == 1){
                    pathLens[i][j] = grid[i-1][j-1];
                    continue;
                }

                pathLens[i][j] = Math.min(pathLens[i - 1][j], pathLens[i][j - 1]) + grid[i-1][j-1];
            }
        }

        Utils.printMatrix(pathLens);

        return pathLens[m][n];

    }
    public static void main(String[] args){

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

}
