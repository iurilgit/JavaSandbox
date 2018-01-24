package matrix;

import array.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruili1 on 1/21/18.
 *
 * basic graph algorithm: find all the connected components of a given graph (in the form of adjacency matrix)

 */
public class LC323_ConnectedComponentsInUndirectedGraph {

    public static int numberOfConnectedComponents(int[][] grid) {

        List<Integer> componentSize = new ArrayList<>();

        int label = -1;
        for(int i = 0; i <grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int size = helper(grid, i, j, label);
                if(size > 0){
                    componentSize.add(size);
                    label--;
                }
            }
        }

        return componentSize.size();
    }

    private static int helper(int[][] grid, int i, int j, int label){
        if( i>= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = label;
            return 1 + helper(grid, i, j+1, label) + helper(grid, i+1, j, label)
                     + helper(grid, i-1, j, label) + helper(grid, i, j-1, label);
        }else{
            return 0;
        }
    }

    public static void main(String[] args){

        int[][] grid1 =
                {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
                 {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int[][] grid2 = {{0,0,1,0}};
        System.out.println(numberOfConnectedComponents(grid1));
        Utils.printMatrix(grid1);
    }

}
