// package BST;
// package com.leetcode.problems;

public class node {
//     node left = null, right = null;
//     int val;
//     public node(int elt){
//         this.val = elt;
//     }
//   }
// package com.leetcode.problems;

public class traversal {
//   public static void main(String orgs[]){
//     node root = new node(1);
//     root.right = new node(2);
//     root.right.left = new node (3);
//     printInOrderTraversal(root);
//   }
//   static public void printInOrderTraversal(node root){
//     if(root == null){
//         return;
//     }
//     printInOrderTraversal(root.left);
//     System.out.print(root.val + " ");
//     printInOrderTraversal(root.right);
//   }
// }

package com.leetcode.BST;
import java.util.List;
import java.util.ArrayList;

//   Definition for a binary tree node.
package com.leetcode.problems;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

package com.leetcode.problems;

public class traversal {
    public static void main(String orgs[]){
        traversal tr = new traversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode (3);
        System.out.println(tr.inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al = helper(root, al);
        return al;
    }
    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> al){
        if(root == null){
            return al;
        }
        al = helper(root.left, al);
        al.add(root.val);
        al = helper(root.right, al);
        return al;
    }
}