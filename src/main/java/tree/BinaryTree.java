package tree;

import java.util.*;

/**
 * Created by iurilgit on 8/23/17.
 */
public class BinaryTree {

    TreeNode root = null;

    public BinaryTree(){

        root = new TreeNode();
    }

    public BinaryTree(TreeNode root){

        this.root = root;
    }

    public boolean isEmpty(){

        return root == null;
    }

    public int countNode(){

        if(root == null) {
            return 0;
        }else {
            return countNode(root);
        }
    }

    private int countNode(TreeNode node){

        if(node == null){
            return 0;
        }else{
            return 1 + countNode(node.left) + countNode(node.left);
        }
    }

    public void printBFT(){

        if(root == null){
            return;
        }

        List<TreeNode> nodesInCurrLayer = new ArrayList<TreeNode>();
        List<TreeNode> nodesInNextLayer = new ArrayList<TreeNode>();

        nodesInCurrLayer.add(root);
        while(!nodesInCurrLayer.isEmpty()){
            nodesInNextLayer = new ArrayList<TreeNode>();
            for(TreeNode node : nodesInCurrLayer){
                node.print();
                if(node.left != null) {
                    nodesInNextLayer.add(node.left);
                }
                if(node.right != null) {
                    nodesInNextLayer.add(node.right);
                }
            }

            nodesInCurrLayer = nodesInNextLayer;
            System.out.println("");
        }
    }

    public void printDFTPreOrder(){

        printDFTPreOrder(root);
        System.out.println("");
    }

    public void printDFTPreOrder(TreeNode node){

        if(node == null){
            return;
        }

        node.print();
        printDFTPreOrder(node.left);
        printDFTPreOrder(node.right);
    }

    public void printDFTPreOrderStack(){

        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;
        stack.push(root);

        while(!stack.isEmpty()){
            currNode = stack.pop();
            currNode.print();

            if(currNode.right != null){
                stack.push(currNode.right);
            }

            if(currNode.left != null) {
                stack.push(currNode.left);
            }
        }

        System.out.println("");
    }

    public void printDFTInOrder(){

        printDFTInOrder(root);
        System.out.println("");
    }

    public void printDFTInOrder(TreeNode node){

        if(node == null){
            return;
        }

        printDFTInOrder(node.left);
        node.print();
        printDFTInOrder(node.right);
    }

    public void printDFTInOrderStack(){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;

        while(currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            currNode.print();

            currNode = currNode.right;
        }

        System.out.println("");
    }

    public void printDFTInOrderStackAndSet(){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;
        stack.push(root);

        Set<TreeNode> visitedNodes = new HashSet<TreeNode>();

        while(!stack.isEmpty()){
            currNode = stack.peek();
            if(currNode.left != null && !visitedNodes.contains(currNode.left)){
                stack.push(currNode.left);
            }else {
                currNode = stack.pop();
                currNode.print();
                visitedNodes.add(currNode);
                if(currNode.right != null && !visitedNodes.contains(currNode.right)) {
                    stack.push(currNode.right);
                }
            }
        }

        System.out.println("");
    }


    public void printDFTInOrderMorris() {

        TreeNode curr, prev;

        if (root == null) {
            return;
        }

        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr.print();
                curr = curr.right;
            } else {
                /* Find the inorder predecessor of current */
                prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                /* Make current as right child of its inorder predecessor */
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    prev.right = null;
                    curr.print();
                    curr = curr.right;
                }   /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

        System.out.println("");
    }

    public void printDFTPostOrder(){

        printDFTPostOrder(root);
        System.out.println("");
    }

    public void printDFTPostOrder(TreeNode node){

        if(node == null){
            return;
        }

        printDFTPostOrder(node.left);
        printDFTPostOrder(node.right);
        node.print();
    }

    public void printDFTPostOrderStack(){

        List<Integer> printOut = new ArrayList<Integer>();
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;
        stack.push(root);

        while(!stack.isEmpty()){
            currNode = stack.pop();
            printOut.add(0, currNode.val);

            if(currNode.left != null){
                stack.push(currNode.left);
            }
            if(currNode.right != null) {
                stack.push(currNode.right);
            }
        }

        for(int i = 0; i < printOut.size(); i++){
            System.out.print(printOut.get(i) + ", ");
        }
        System.out.println("");
    }

    public void printDFTPostOrderStackAndSet(){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;
        stack.push(root);

        Set<TreeNode> visitedNodes = new HashSet<TreeNode>();

        TreeNode prevNode = null;
        while(!stack.isEmpty()){
            currNode = stack.peek();
            if(currNode.left != null && !visitedNodes.contains(currNode.left)){
                stack.push(currNode.left);
            }else if(currNode.right != null && !visitedNodes.contains(currNode.right)) {
                stack.push(currNode.right);
            }else{
                currNode = stack.pop();
                currNode.print();
                visitedNodes.add(currNode);
            }
        }

        System.out.println("");
    }

    public int findMaxDepth(){

        return findMaxDepth(root);
    }

    /**
     * LC 104:  Given a binary tree, find its maximum depth.

     The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * @param node
     * @return
     */
    public int findMaxDepth(TreeNode node){

        if(node == null){
            return 0;
        }

        return 1 + Math.max(findMaxDepth(node.left), findMaxDepth(node.right));
    }


    public void invertTree(){

        invertTree(root);
    }

    /**
     * LC 226: Invert a binary tree. (mirror it)
     * @param node
     */
    public TreeNode invertTree(TreeNode node){

        if(node == null){
            return node;
        }

        TreeNode temp;
        temp = node.left;
        node.setLeft(invertTree(node.right));
        node.setRight(invertTree(temp));

        return node;
    }

    public void printDiagnalTraversal(){

        List<ArrayList<TreeNode>> lists = new ArrayList<ArrayList<TreeNode>>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currNode = root;
        stack.push(root);

        int leftIdx = 0;
        int rightIdx = 0;

        while(!stack.isEmpty() && currNode != null){
            if(currNode.left != null){
                stack.push(currNode.left);
                currNode = currNode.left;

                if(lists.size() <= leftIdx){
                    lists.add(leftIdx, new ArrayList<TreeNode>());
                }
                lists.get(leftIdx).add(rightIdx, currNode);

                leftIdx ++;
            }else {
                currNode = stack.pop();
//                currNode.print();
                if(currNode.right != null) {
                    stack.push(currNode.right);
                    currNode = currNode.right;

                    if(lists.size() <= leftIdx){
                        lists.add(leftIdx, new ArrayList<TreeNode>());
                    }
                    lists.get(leftIdx).add(rightIdx, currNode);

                    rightIdx++;
                }
            }
        }

        // print
        for(ArrayList<TreeNode> list : lists){
            for(TreeNode node: list){
                node.print();
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();

        // complex tree
        tree.root.setVal(1);
        tree.root.setLeft(2);
        tree.root.setRight(3);
        tree.root.left.setLeft(4);
        tree.root.left.setRight(5);
        tree.root.right.setLeft(6);
        tree.root.left.left.setRight(7);


//        tree.root.setVal(1);
//        tree.root.setLeft(3);
//        tree.root.left.setLeft(2);

//        tree.printBFT();

//        tree.printDFTPreOrder();
//        tree.printDFTPreOrderStack();

//        tree.printDFTInOrder();
//        tree.printDFTInOrderStack();
//        tree.printDFTInOrderStackAndSet();
//        tree.printDFTInOrderMorris();

        tree.printDFTPostOrder();
        tree.printDFTPostOrderStack();
//        tree.printDFTPostOrderStackAndSet();

//        List<Integer> valsInOrder = new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 2, 5, 1, 3, 6}));
//        List<Integer> valsPreOrder = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2, 4, 5, 3, 6}));
//        tree.root = tree.reconstructTreeFromDFT(valsInOrder, valsPreOrder);
//        tree.printDFTInOrder();
//        tree.printDFTPreOrder();

//        tree.printDiagnalTraversal();
//
//        // LC 104
//        System.out.println("max depth: " + tree.findMaxDepth());
//
//        // LC 226:
//        tree.invertTree();
//        tree.printBFT();
    }

}
