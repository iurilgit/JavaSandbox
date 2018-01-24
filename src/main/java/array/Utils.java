package array;

import java.util.Map;

/**
 * Created by ruili1 on 10/6/17.
 */
public class Utils {

    public static void printArray(int[] nums){
        for(int num : nums){
            System.out.print(num + ", ");
        }
        System.out.println("");
    }

    public static void printMatrix(int[][] matrxi){
        for(int i = 0; i < matrxi.length; i++){
            for(int j = 0; j < matrxi[i].length; j++){
                System.out.print(matrxi[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    public static void printMap(Map<Integer, Integer> map){
        for(Integer k : map.keySet()){
            System.out.println(k + " -> " + map.get(k));
        }
    }
}
