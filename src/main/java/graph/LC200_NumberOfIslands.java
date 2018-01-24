package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ruili1 on 10/20/17.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 */
public class LC200_NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int height = grid.length;
        int width = 0;
        if(height > 0) {
            width = grid[0].length;
        }else{
            return 0;
        }

        int[][] labels = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    labels[i][j] = i*width + j;
                    if(i > 0 && grid[i -1][j] == '1'){
                        labels[i][j] = labels[i-1][j];
                    }
                    if(j > 0 && grid[i][j-1] == '1'){
                        labels[i][j] = labels[i][j-1];
                    }
                }else{
                    labels[i][j] = -1;
                }
            }
        }

        printMatrix(labels);

        Set<Integer> islandIds = new HashSet<Integer>();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                int label = labels[i][j];
                if(label < 0){
                    continue;
                }
                int i2 = label/width;
                int j2 = label - i2*width;
                while(label != i2*width + j2){
                    i2 = label/width;
                    j2 = label - i2*width;
                    label = labels[i2][j2];
                }
                islandIds.add(label);
            }
        }

        return islandIds.size();
    }

    private static void printMatrix(int[][] matrix){

        int height = matrix.length;
        int width = matrix[0].length;

        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){

//        char[][] grid = {{'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};

        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}
