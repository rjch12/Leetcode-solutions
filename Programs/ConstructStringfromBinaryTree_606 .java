
class ConstructStringfromBinaryTree_606 {
    public static void main(String[] args) {
        ConstructStringfromBinaryTree_606 cst = new ConstructStringfromBinaryTree_606();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(cst.tree2str(root));
    }

    public String tree2str(TreeNode root) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null)
            return "" + root.val;

        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (left == "" && right == "")
            return root.val + "";

        if (left != "")
            return "" + root.val + '(' + left + ')';
        else
            return "" + root.val + '(' + root.val + ')' + '(' + root.right + ')';
    }
}

