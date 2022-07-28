
class flattenTree_114 {
  public static void main(String[] args) {
    // TreeNode root = new TreeNode(1);
    // root.left = new TreeNode(2);
    // root.left.left = new TreeNode(3);
    // root.left.right = new TreeNode(4);
    // root.right = new TreeNode(5);
    // root.right.right = new TreeNode(6);

    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);

    flattenTree_114 fl = new flattenTree_114();
    fl.flatten(root);
  }

  void flatten(TreeNode root) {
    if (root == null)
      return;

    if (root.left != null) {
      flatten(root.left);
      TreeNode temp = root.right;

      root.right = root.left;
      root.left = null;
      TreeNode curr = root.right;

      while (curr.right != null)
        curr = curr.right;

        curr.right = temp;
    }
    flatten(root.right);
  }
}