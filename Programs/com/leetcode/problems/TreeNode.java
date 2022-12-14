package com.leetcode.problems;

public class TreeNode {
  public TreeNode left;
  public TreeNode right;
  public int val;

  public TreeNode(int value) {
    this.left = null;
    this.right = null;
    this.val = value;
  }

  public TreeNode() {
  }

  public TreeNode(int value, TreeNode lNode, TreeNode rNode) {
    this.left = lNode;
    this.right = rNode;
    this.val = value;
  }
}
