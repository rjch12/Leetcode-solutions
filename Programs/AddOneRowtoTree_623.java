
class AddOneRowtoTree_623 {
    public static void main(String[] args) {
        AddOneRowtoTree_623 a = new AddOneRowtoTree_623();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        

        TreeNode r = a.addOneRow(root, 1, 2);
        a.display(r);
    }

    public void display(TreeNode r) {
        if (r == null) {
            return;
        }
        System.out.print(r.val + " ");
        display(r.left);
        display(r.right);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
        } else
            dfs(root, val, 0, depth);

        return root;
    }

    public void dfs(TreeNode root, int val, int currDepth, int depth) {
        if (root == null)
            return;
        if (currDepth == depth - 1) {
            TreeNode temp = root.left;
            root.left = new TreeNode(val);
            root.left.left = temp;
            temp = root.right;
            root.right = new TreeNode(val);
            root.right.right = temp;
        }
        else {
            dfs(root.left, val, currDepth + 1, depth);
            dfs(root.right, val, currDepth + 1, depth);
        }
    }
}
