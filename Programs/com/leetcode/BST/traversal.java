package com.leetcode.BST;

import java.util.List;
import java.util.ArrayList;
import com.leetcode.problems.TreeNode;

public class traversal {
    public static void main(String orgs[]) {
        traversal tr = new traversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(tr.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al = helper(root, al);
        return al;
    }

    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> al) {
        if (root == null) {
            return al;
        }
        al = helper(root.left, al);
        al.add(root.val);
        al = helper(root.right, al);
        return al;
    }
}
