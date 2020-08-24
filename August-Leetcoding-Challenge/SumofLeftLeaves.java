/*
* Find the sum of all left leaves in a given binary tree.
* Example:
        3
       / \
      9  20
        /  \
       15   7
    * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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
    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        int ans = 0;
//        if (root.left != null) {
//            if (root.left.left == null && root.left.right == null) {
//                ans += root.left.val;
//            } else {
//                ans += sumOfLeftLeaves(root.left);
//            }
//        }
//        if (root.right != null) {
//            ans += sumOfLeftLeaves(root.right);
//        }
//
//        return ans;
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        /* This node is a leaf, if it's a left leaf, we return the value
          if it's a right leaf we return 0 since right leaf doesn't count */
        if(root.left == null && root.right == null){
            if(isLeft){
                return root.val;
            }
            return 0;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
