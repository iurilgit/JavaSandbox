package tree;

/**
 * Created by ruili1 on 8/24/17.
 *
 Given n, how many structurally unique BST's (binary searchRange trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */
public class LC96_NumOfTrees {

    public static int numTrees(int n) {

//        if(n == 0 || n == 1) {
//            return 1;
//        }else{
//            int total = 0;
//            for(int m = 1; m <= n; m++) {
//                total += numTrees(m-1)*numTrees(n-m);
//            }
//            return total;
//        }

        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(i == 1){
                nums[i] = 1;
            }else{
                nums[i] = 0;
                for(int m = 1; m <= i; m++) {
                    nums[i] += nums[m-1]*nums[i-m];
                }
            }
        }

        return nums[n];
    }

    public static void main(String[] args){

        System.out.println(numTrees(1));
        System.out.println(numTrees(2));
        System.out.println(numTrees(3));
        System.out.println(numTrees(4));
    }
}
