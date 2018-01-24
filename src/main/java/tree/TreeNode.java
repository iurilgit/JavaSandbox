package tree;

/**
 * Created by iurilgit on 8/23/17.
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.val = data;
        left = null;
        right = null;
    }

    public TreeNode(){
        this(0);
    }

//    // getters
//    public int getVal(){
//
//        return val;
//    }
//
//    public TreeNode getLeft(){
//
//        return left;
//    }
//
//    public TreeNode getRight(){
//
//        return right;
//    }

    // setters
    public void setVal(int val){

        this.val = val;
    }

    public void setLeft(int data){
        if(left == null){
            left = new TreeNode(data);
        }else {
            left.val = data;
        }
    }

    public void setRight(int data){
        if(right == null){
            right = new TreeNode(data);
        }else {
            right.val = data;
        }
    }

    public void setLeft(TreeNode left){

        this.left = left;
    }

    public void setRight(TreeNode right){

        this.right = right;
    }

    public void print(){

        System.out.print(val + ", ");
     }

    public static void main(String[] args){

    }
}
