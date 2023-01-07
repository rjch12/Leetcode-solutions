package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class pathSum2_113 {
    /**
     * Definition for a binary tree node.
     *      * 
     * public      * 
     * package com.leetcode.problems;

public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    List<List<Integer>> res;

    public static void main(String[] args) {
        pathSum2_113 ps = new pathSum2_113();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = ps.pathSum(root, 22);
        for (List<Integer> r : res) {
            System.out.println(r);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int target, List<Integer> al) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                al.add(root.val);
                res.add(new ArrayList<>(al));
                al.remove(al.size() - 1);
            }
            return;
        }
        al.add(root.val);
        dfs(root.left, target - root.val, al);
        dfs(root.right, target - root.val, al);
        al.remove(al.size() - 1);
    }
}
