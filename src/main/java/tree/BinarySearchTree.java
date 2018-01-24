package tree;

/**
 * Created by ruili1 on 8/24/17.
 */
public class BinarySearchTree extends BinaryTree{

    public BinarySearchTree(){
        super();
    }

    public void insert(int x){

        insert(root, x);
    }

    public TreeNode insert(TreeNode node, int x){

        if(node == null){
            node = new TreeNode(x);
            return node;
        }

        if(node.val > x){
            node.left = insert(node.left, x);
        }else if(node.val < x){
            node.right = insert(node.right, x);
        }else{
            // do nothing since x already exists
        }

        return node;
    }

    public void delete(int x){

        root = delete(root, x);
    }

    public TreeNode delete(TreeNode node, int x){

        if(node == null){
            return null;
        }

        if(node.val == x){
            if(node.left != null){
                TreeNode maxFromLeft = getMax(node.left);
                node.val = maxFromLeft.val;
                node.left = delete(maxFromLeft, maxFromLeft.val);
            }else if(node.right != null){
                TreeNode minFromRight = getMin(node.right);
                node.val = minFromRight.val;
                node.right = delete(minFromRight, minFromRight.val);
            }else{
                return null; // there is no child, so delete itself
            }
        }else if(node.val > x){
            node.left = delete(node.left, x);
        }else{
            node.right = delete(node.right, x);
        }

        return node;
    }

    public TreeNode search(int x){

        return search(root, x);
    }

    public TreeNode search(TreeNode node, int x){

        if(node == null){
            return null;
        }

        if(node.val == x){
            return node;
        }else if(x < node.val){
            return search(node.left, x);
        }else{
            return search(node.right, x);
        }
    }

    public TreeNode getMin(TreeNode node){

        if(node == null){
            return null;
        }

        if(node.left == null){
            return node;
        }else{
            return getMin(node.left);
        }
    }

    public TreeNode getMax(){

        return getMax(root);
    }

    public TreeNode getMax(TreeNode node){

        if(node == null){
            return null;
        }

        if(node.right == null){
            return node;
        }else{
            return getMax(node.right);
        }
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new TreeNode(3);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        // traversal
        System.out.println("BST");
        tree.printBFT();
        System.out.print("DFT pre order: ");
        tree.printDFTPreOrder();
        System.out.print("DFT in order: ");
        tree.printDFTInOrder();

        // searchRange
//        TreeNode node = tree.searchRange(6);
//        if (node != null) {
//            node.print();
//        } else {
//            System.out.println("no such value in the tree");
//        }

        // min, max
//        TreeNode min = tree.getMin(tree.root);
//        System.out.print("min: ");
//        min.print();
//        System.out.println("");
//        TreeNode max = tree.getMax(tree.root);
//        System.out.print("max: ");
//        max.print();
//        System.out.println("");

        // delete
        tree.delete(4);
        System.out.println("BST");
        tree.printBFT();
        System.out.print("DFT in order: ");
        tree.printDFTInOrder();
    }
}
