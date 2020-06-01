/*
* Invert a binary tree.
* Example:
    Input:
         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    Output:
         4
       /   \
      7     2
     / \   / \
    9   6 3   1
* 
* Approach: Write a recursive function which swaps right node and left node and call it on both right and left children
    * It should return null if the node is null
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
