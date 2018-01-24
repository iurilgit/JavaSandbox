package tree;

import java.util.Stack;

/**
 * Created by ruili1 on 8/24/17.
 */
public class BSTIterator {

    TreeNode currNode = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {

        if(root != null) {
            currNode = root;
            stack.push(root);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !(stack.isEmpty() && currNode == null);
    }

    /** @return the next smallest number */
    public Integer next() {

        Integer val = null;
        if(hasNext()){
            if(currNode != null) {
                while (currNode.left != null) {
                    stack.push(currNode.left);
                    currNode = currNode.left;
                }
            }

            currNode = stack.pop();
            val = currNode.val;
            if(currNode.right != null) {
                stack.push(currNode.right);
                currNode = currNode.right;
            }else{
                currNode = null;
            }
        }

        return val;
    }

    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new TreeNode(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

//        tree.root = new TreeNode(3);
//        tree.insert(2);
//        tree.insert(1);
//        tree.insert(4);

        tree.printBFT();
        tree.printDFTInOrder();

        BSTIterator iterator = new BSTIterator(tree.root);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
