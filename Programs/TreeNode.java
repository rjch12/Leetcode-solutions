public class TreeNode {
  TreeNode left;
  TreeNode right;
  int val;
  
  public TreeNode(int value) {
    this.left = null;
    this.right = null;
    this.val = value;
  }

  public TreeNode(int value, TreeNode lNode, TreeNode rNode) {
    this.left = lNode;
    this.right = rNode;
    this.val = value;
  }
}
