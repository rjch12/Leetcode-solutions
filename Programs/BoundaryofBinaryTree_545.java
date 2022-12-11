/*
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes. 
 * (The values of the nodes may still be duplicates.)
 * Left boundary is defined as the path from root to the left-most node. 
 * Right boundary is defined as the path from root to the right-most node. 
 * If the root doesn’t have left subtree or right subtree, then the root itself is left boundary or right boundary. 
 * Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * 
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree 
 * if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * 
 * The right-most node is also defined by the same way with left and right exchanged.
 * 
 * Example 1: 
 * Input:
        1
         \
          2
         / \
        3   4

 * Ouput:
 * [1, 3, 4, 2]
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right 
 * boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 */

import java.util.*;

class BoundaryofBinaryTree_545 {
    public static void main(String[] args) {
        BoundaryofBinaryTree_545 b = new BoundaryofBinaryTree_545();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(b.boundaryOfBinaryTree(root));
    }

    int maxLevel = 0;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        return null;
    }
}