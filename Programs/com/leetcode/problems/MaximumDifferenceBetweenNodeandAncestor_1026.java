/**
 * 1026. Maximum Difference Between Node and Ancestor
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/
 * 
 * Given the root of a binary tree, find the maximum value v for which there exist different 
 * nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 * 
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is 
 * an ancestor of b.
 * 
 * Example: 
 * Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * Output: 7
 * Explanation: We have various ancestor-node differences, some of which are given below :
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 
 * Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 */

package com.leetcode.problems;

public class MaximumDifferenceBetweenNodeandAncestor_1026 {
    int min;

    public static void main(String[] args) {
        MaximumDifferenceBetweenNodeandAncestor_1026 m = new MaximumDifferenceBetweenNodeandAncestor_1026();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(m.maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        min = Integer.MIN_VALUE;
        find(root, root.val, root.val);
        return min;
    }

    public void find(TreeNode root, int largestNode, int smallestNode) {
        if (root == null)
            return;

        largestNode = Math.max(largestNode, root.val);
        smallestNode = Math.min(smallestNode, root.val);

        if (root.left == null && root.right == null) {
            min = Math.max(min, (largestNode - smallestNode));
            return;
        }

        find(root.left, largestNode, smallestNode);
        find(root.right, largestNode, smallestNode);
    }
}
