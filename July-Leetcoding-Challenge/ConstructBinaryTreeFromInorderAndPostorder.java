/*
* Given inorder and postorder traversal of a tree, construct the binary tree.
* Note: You may assume that duplicates do not exist in the tree.
* For example, given
    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    Return the following binary tree:
        3
       / \
      9  20
        /  \
       15   7
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
    int postOrderEnd = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        postOrderEnd = postorder.length-1;
        return constructBT(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode constructBT(int[] A, int[] B, int aStart, int aEnd) {
        if (aStart > aEnd) {
            return null;
        }

        TreeNode root = new TreeNode(B[postOrderEnd--]);

        if (aStart == aEnd) {
            return root;
        }
        int idx = findIdx(A, aStart, aEnd, root.val);

        root.right = constructBT(A,B,idx+1, aEnd);
        root.left = constructBT(A,B,aStart, idx-1);

        return root;
    }

    public int findIdx(int[] A, int start, int end, int num) {
        for (int i=start;i<=end;i++) {
            if (A[i] == num) return i;
        }

        return -1;
    }
}
