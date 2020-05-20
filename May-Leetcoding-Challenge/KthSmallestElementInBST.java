/*
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
* Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
* Example 1:
    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1

* Example 2:
    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3
* Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
    * How would you optimize the kthSmallest routine?
*
* Approach: Do inorder search and keep track of number of nodes visited and return when you have reached kth node.
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
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        TreeNode node = kthSmallestUtil(root,k);
        return node == null ? 0 : node.val;
    }

    public TreeNode kthSmallestUtil(TreeNode root, int k) {
        if (root == null)
            return null;

        TreeNode left = kthSmallestUtil(root.left, k);

        if (left != null)
            return left;

        count++;
        if (count == k)
            return root;

        return kthSmallestUtil(root.right, k);
    }
}
