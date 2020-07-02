/*
* Given a binary tree, return the bottom-up level order traversal of its nodes' values.
* (ie, from left to right, level by level from leaf to root).
* For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    return its bottom-up level order traversal as:
        [
          [15,7],
          [9,20],
          [3]
        ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if(root == null) {
            return resList;
        }

        dfs(root, 0, resList);
        return resList;
    }

    public void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if(root == null) {
            return;
        }

        if(depth == res.size()) {
            res.add(0, new ArrayList<Integer>());
        }

        res.get(res.size() - depth - 1).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}
