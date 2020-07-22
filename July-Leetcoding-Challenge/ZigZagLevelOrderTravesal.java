/*
* Given a binary tree, return the zigzag level order traversal of its nodes' values.
* (ie, from left to right, then right to left for the next level and alternate between).
* For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    return its zigzag level order traversal as:
        [
          [3],
          [20,9],
          [15,7]
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
    int height = Integer.MIN_VALUE;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        getHeight(root, 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(new ArrayList<Integer>());
        }
        helper(root, 1, result);
        return result;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (level%2 == 0) {
            result.get(level-1).add(0, node.val);
        } else {
            result.get(level-1).add(node.val);
        }
        helper(node.left, level + 1, result);
        helper(node.right, level + 1, result);
        return;
    }
    private void getHeight(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (node.right == null && node.left == null) {
            height = level > height ? level : height;
            return;
        }
        getHeight(node.left, level+1);
        getHeight(node.right, level+1);
        return;
    }
}
