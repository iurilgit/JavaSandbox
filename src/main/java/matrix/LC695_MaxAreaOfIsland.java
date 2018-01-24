package matrix;

import array.Utils;

/**
 * Created by ruili1 on 1/4/18.
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 Example 2:
 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.

 ----
 solution:
 recursive: scan through the matrix row by row and column by column.
 if a cell is 1, modify it to be -1, recursively check its connecting 4 neighbors and add their areas to the whole area.
 Keep a global max and update it.

 */
public class LC695_MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        for(int i = 0; i <grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(max, helper(grid, i, j));
            }
        }

        return max;
    }

    private static int helper(int[][] grid, int i, int j){
        if( i>= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = -1;
            return 1 + helper(grid, i, j+1) + helper(grid, i+1, j) + helper(grid, i-1, j) + helper(grid, i, j-1) ;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){

        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = {{0,0,1,0}};
        System.out.println(maxAreaOfIsland(grid2));
        Utils.printMatrix(grid2);
    }

}
