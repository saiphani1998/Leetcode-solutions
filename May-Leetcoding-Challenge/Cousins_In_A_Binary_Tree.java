/*
* In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
* Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
* We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
* Return true if and only if the nodes corresponding to the values x and y are cousins.
* Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false
* Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true
* Example 3:
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false
*
* */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return ((level(root, x, 1) == level(root, y, 1)) && (!isSibling(root, x, y)));
    }
    public int level(TreeNode node, int ptr, int lev) {
        if (node == null) {
            return 0;
        }
        if (node.val == ptr) {
            return lev;
        }
        int l = level(node.left, ptr, lev + 1);
        if (l != 0) {
            return l;
        }
        return level(node.right, ptr, lev + 1);
    }

    boolean isSibling(TreeNode node, int a, int b) {
        if (node == null)
            return false;
        if (node.left == null && node.right != null) {
            return isSibling(node.right, a, b);
        }
        if (node.left != null && node.right == null) {
            return isSibling(node.left, a, b);
        }
        if (node.left == null && node.right == null) {
            return false;
        }

        return ((node.left.val == a && node.right.val == b) ||
                (node.left.val == b && node.right.val == a) ||
                isSibling(node.left, a, b) ||
                isSibling(node.right, a, b));
    }
}