package com.leetcode.facebook;

import com.leetcode.problems.TreeNode;

public class invertBST {

  public static void main(String[] args) {
    invertBST ibst = new invertBST();

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(7);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    ibst.display(ibst.invertTree(root));
  }

  public void display(TreeNode root) {
    if (root == null)
      return;

    display(root.left);
    System.out.print(root.val + " ");
    display(root.right);

  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    else
      invert(root);
    return root;
  }

  public void invert(TreeNode root) {

    if (root == null || (root.left == null && root.right == null))
      return;

    if (root.left == null && root.right != null) {
      root.left = root.right;
      root.right = null;
    } else if (root.left != null && root.right == null) {
      root.right = root.left;
      root.left = null;
    } else if (root.left != null && root.right == null) {
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
    }

    invert(root.right);
    invert(root.left);
  }
}
