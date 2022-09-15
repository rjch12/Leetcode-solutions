import java.util.*;

class stepByStepDirectionFromBinaryTreeNodetoAnother_2096 {
  public static void main(String[] args) {
    stepByStepDirectionFromBinaryTreeNodetoAnother_2096 s = new stepByStepDirectionFromBinaryTreeNodetoAnother_2096();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);
    System.out.println(s.getDirections(root, 3, 6));

    // TreeNode root = new TreeNode(2);
    // root.left = new TreeNode(1);
    // System.out.println(s.getDirections(root, 2, 1));

    // TreeNode root = new TreeNode(1);
    // root.right = new TreeNode(10);
    // root.right.left = new TreeNode(12);
    // root.right.right = new TreeNode(13);

    // [1,null,10,12,13,4,6,null,15,null,null,5,11,null,2,14,7,null,8,null,null,null,9,3]
    // System.out.println(s.getDirections(root, 6, 15));
  }

  public String getDirections(TreeNode root, int startValue, int destValue) {
    List<TreeNode> sp = new ArrayList<>();
    List<TreeNode> dp = new ArrayList<>();

    findPath(root, startValue, sp);
    findPath(root, destValue, dp);

    return findDirections(sp, dp);
  }

  public String findDirections(List<TreeNode> sp, List<TreeNode> dp) {
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while (i < sp.size() && j < dp.size()) {
      if (sp.get(i) == dp.get(i)) {
        i++;
        j++;
      } else
        break;
    }

    for (; i < sp.size(); i++) {
      sb.append('U');
    }

    for (; j < dp.size(); j++) {
      // System.out.print(dp.get(j - 1).val);

      if (dp.get(j - 1).left != null && dp.get(j) == dp.get(j - 1).left)
        sb.append('L');
      if (dp.get(j - 1).right != null && dp.get(j) == dp.get(j - 1).right)
        sb.append('R');
    }

    return sb.toString();
  }

  public boolean findPath(TreeNode root, int elt, List<TreeNode> al) {
    if (root == null)
      return false;

    if (root.val == elt) {
      al.add(root);
      return true;
    }

    al.add(root);
    if (findPath(root.left, elt, al)) {
      return true;
    } else if (findPath(root.right, elt, al)) {
      return true;
    }
    al.remove(al.size() - 1);
    return false;
  }
}