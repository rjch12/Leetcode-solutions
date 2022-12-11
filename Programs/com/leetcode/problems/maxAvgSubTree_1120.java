package com.leetcode.problems;

public class maxAvgSubTree_1120 {

  public class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int e) {
      this.val = e;
      this.left = null;
      this.right = null;
    }
  }

  public static void main(String[] args) {
    maxAvgSubTree_1120 mas = new maxAvgSubTree_1120();
    TreeNode root = mas.new TreeNode(2);
    root.right = mas.new TreeNode(1);
    System.out.println(mas.maximumAverageSubtree(root));
  }

  public double maximumAverageSubtree(TreeNode root) {
    return getAvg(root);
  }

  double getAvg(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.val;
    }

    double leftSubTree = 0.0d, rightSubTree = 0.0d, divFactor = 3;
    if (root.left == null || root.right == null)
      divFactor = 2;

    if (root.left != null)
      leftSubTree = getAvg(root.left);

    if (root.right != null)
      rightSubTree = getAvg(root.right);

    return Math.max(Math.max(leftSubTree, rightSubTree), (leftSubTree + rightSubTree + root.val) / divFactor);
  }
}
