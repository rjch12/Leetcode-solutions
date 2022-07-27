

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class TreeNode {
  TreeNode left;
  TreeNode right;
  int val;

  public TreeNode(int value) {
    this.left = null;
    this.right = null;
    this.val = value;
  }
}

class FindLeavesOfBinartTree_366 {
  public static void main(String[] args) {
    FindLeavesOfBinartTree_366 flobt = new FindLeavesOfBinartTree_366();

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    List<List<Integer>> res = flobt.findLeaves(root);

    System.out.println(res);
  }

  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    
    while (root.left != null || root.right != null) {
      List<Integer> temp = new ArrayList<>();
      preorder(root, temp);
      res.add(temp);
    }

    res.add( Arrays.asList(root.val));
    return res;
  }

  public void preorder(TreeNode root, List<Integer> al) {
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null) {
        al.add(root.left.val);
        root.left = null;
      } else {
        preorder(root.left, al);
      }
    }
    if (root.right != null)

    {
      if (root.right.left == null && root.right.right == null) {
        al.add(root.right.val);
        root.right = null;
      } else {
        preorder(root.right, al);
      }
    }
  }
}