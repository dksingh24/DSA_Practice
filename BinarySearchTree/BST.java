import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST {

    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    public void insert(int val){
        root = insert(this.root, val);
    }

    private TreeNode insert(TreeNode root, int val){
        if(root == null){
            root = new TreeNode(val);
            return root;
        }
        if(root.data > val)
            root.left = insert(root.left, val);
        else if(root.data < val)
            root.right = insert(root.right, val);
        return root;
    }

    public int height(){
        return height(root);
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    

    // region Delete Node
    public void delete(int val) {
        if(root == null)
            throw new IllegalStateException("Tree is Empty");
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode root, int val){
        if(root == null)
            throw new IllegalStateException("The give node value is not present in BST.");
        if(root.data > val)
            root.left = delete(root.left, val);
        else if(root.data < val)
            root.right = delete(root.right, val);
        else{
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                TreeNode successor = findMinNode(root.right);
                root.data = successor.data;
                root.right = delete(root.right, successor.data);
            }
        }
        return root;
    }
    // endregion

    // region Find Maximum node and its value
    /**
     * Finds the value of the maximum value node of BST.
     * @return The integer(int) value of the maximum value node.
     * @throws  NoSuchElementException in case the Tree is Empty.
     */
    public int findMaxValue(){
        TreeNode max = findMaxNode();
        if(max != null)
            return max.data;
        throw new NoSuchElementException("The Tree is Empty");
    }

    /**
     * Finds the maximum value node of BST.
     * @return The maximum value node of BST.
     */
    private TreeNode findMaxNode(){
        if(root == null)
            return null;
        TreeNode temp = root;
        while(temp.right != null)
            temp = temp.right;
        return temp;
    }
    // endregion

    // region Find Minimum Node and its value
    /**
     * Finds the value of the minimum value node of BST
     * @return The integer(int) value of the minimum node of BST
     */
    public int findMinValue(){
        TreeNode min = findMinNode();
        if(min != null)
            return min.data;
        throw new NoSuchElementException("The Tree is empty");
    }
    
    /**
     * Find the minimum node of BST
     * @return The minimum node of BST
     */
    private TreeNode findMinNode(){
        if(root == null)
            return null;
        TreeNode temp = root;
        while(temp.left != null)
            temp = temp.left;
        return temp;
    }

    private TreeNode findMinNode(TreeNode node){
        if(node == null)
            return null;
        while(node.left != null)
            node = node.left;
        return node;
    }
    // endregion
    
    //region Search Methods
    public boolean isPresent(int val){
        return search(val) != null;
    }

    /**
     * Recursive Search Method
     */
    private TreeNode search(int val){
        // return searchHelper(root, val);
        return searchIterative(val);
    }

    /**  
     * Recursive Search Helper Method
     */
    private TreeNode searchHelper(TreeNode root, int val){
        if(root == null || root.data == val)
            return root;
        if(root.data > val)
            return searchHelper(root.left, val);
        else if(root.data < val)
            return searchHelper(root.right, val);
        return null;
    }

    /**
    * Iterative Search
    */
    private TreeNode searchIterative(int val){
        TreeNode temp = root;
        while(temp != null){
            if(temp.data == val)
                return temp;
            temp = temp.data > val ? temp.left : temp.right;
        }
        return null;
    }
    // endregion

    public void printsBST() {
        if (root == null) {
            System.out.println("BST is Empty!");
            return;
        }

        System.out.println("BST Status:");

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean hasNonNull = true;

        while (hasNonNull) {
            int size = queue.size();
            hasNonNull = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == null) { 
                    System.out.print("null ");
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    System.out.print(node.data + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);

                    if (node.left != null || node.right != null) {
                        hasNonNull = true;
                    }
                }
            }
        }
    }

    public void printBST(){
        if(root == null){
            System.out.println("BST is Empty!");
            return;
        }
        System.out.println("BST Status :");
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        pendingNodes.offer(root);
        while(!pendingNodes.isEmpty()){
            int size = pendingNodes.size();
            
            while(size-- > 0){
                TreeNode node = pendingNodes.poll();
                if(node != null)
                    System.out.print(node.data + " ");
                else{
                    System.out.print("null ");
                    break;
                }
                
                pendingNodes.offer(node.left);
                pendingNodes.offer(node.right);
                
            }
        }
    }
}
