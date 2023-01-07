/*
 * Problem: 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the 
 * sequence has an edge connecting them. A node can only appear in the sequence at most once. 
 * Note that the path does not need to pass through the root.The path sum of a path is the sum
 * of the node's values in the path.
 * 
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * 
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 */


package com.leetcode.problems;

public class BinaryTreeMaximumPathSum_124 {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        findPath(root);
        return max;
    }

    public int findPath(TreeNode root) {
        if (root == null)
            return 0;

        int lstSum = findPath(root.left);
        int rstSum = findPath(root.right);

        if (lstSum < 0)
            lstSum = 0;
        if (rstSum < 0)
            rstSum = 0;

        max = Math.max(max, root.val + lstSum + rstSum);
        return Math.max(root.val + lstSum, root.val + rstSum);
    }
}
