package BinarySearchTree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST {

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    /* =========================================================
       INSERT
       ========================================================= */

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else if (val > root.data)
            root.right = insert(root.right, val);

        return root; // ignore duplicates
    }

    /* =========================================================
       SEARCH
       ========================================================= */

    public boolean isPresent(int val) {
        return searchRecursive(root, val) != null;
    }

    private TreeNode searchRecursive(TreeNode root, int val) {
        if (root == null || root.data == val)
            return root;

        if (val < root.data)
            return searchRecursive(root.left, val);
        else
            return searchRecursive(root.right, val);
    }

    private TreeNode searchIterative(int val) {
        TreeNode temp = root;

        while (temp != null) {
            if (temp.data == val)
                return temp;

            temp = val < temp.data ? temp.left : temp.right;
        }

        return null;
    }

    /* =========================================================
       FIND MIN
       ========================================================= */

    public int findMinValue() {
        if (root == null)
            throw new NoSuchElementException("Tree is empty");

        return findMinNode(root).data;
    }

    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null)
            node = node.left;

        return node;
    }

    /* =========================================================
       FIND MAX
       ========================================================= */

    public int findMaxValue() {
        if (root == null)
            throw new NoSuchElementException("Tree is empty");

        return findMaxNode(root).data;
    }

    private TreeNode findMaxNode(TreeNode node) {
        while (node.right != null)
            node = node.right;

        return node;
    }

    /* =========================================================
       DELETE
       ========================================================= */

    public void delete(int val) {
        if (!isPresent(val))
            throw new IllegalStateException("Value not present in BST");

        root = delete(root, val);
    }

    private TreeNode delete(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {

            // Case 1: No child
            if (root.left == null && root.right == null)
                return null;

            // Case 2: One child
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            // Case 3: Two children
            TreeNode successor = findMinNode(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    /* =========================================================
       HEIGHT (Number of Levels / Nodes Based)
       ========================================================= */

    public int height() {
        return height(root);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void printBST() {
        if (root == null) {
            System.out.println("BST is Empty!");
            return;
        }

        System.out.println("BST Structure (Level Order):");

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

                    if (node.left != null || node.right != null)
                        hasNonNull = true;
                }
            }
        }

        System.out.println();
    }
}