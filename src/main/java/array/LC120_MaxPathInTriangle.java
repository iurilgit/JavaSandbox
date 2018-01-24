package array;

import java.util.List;

/**
 * Created by ruili1 on 11/20/17.
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space,
 where n is the total number of rows in the triangle.


 */
public class LC120_MaxPathInTriangle {

    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {

            for(int i = triangle.size() - 2; i >= 0; i--){
                for(int j = 0; j < triangle.get(i).size(); j++){
                    // get min of the middle and right children of the current node
                    int midChild = triangle.get(i+1).get(j);
                    int rightChild = triangle.get(i+1).get(j+1);
                    int minChild = Math.min(midChild, rightChild);

                    // // if there is left child
                    // // But this question doesn't treat left child as a child
                    // if(j > 0){
                    //     int leftChild = triangle.get(i+1).get(j-1);
                    //     minChild = Math.min(leftChild, minChild);
                    // }

                    // update current value in triangle as the max sum
                    int currValue = triangle.get(i).get(j);
                    triangle.get(i).set(j, currValue + minChild);
                }
            }

            return triangle.get(0).get(0);
        }
    }
}
