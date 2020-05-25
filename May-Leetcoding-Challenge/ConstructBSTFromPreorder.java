/*
* Return the root node of a binary search tree that matches the given preorder traversal.
* (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val,
    * and any descendant of node.right has a value > node.val.
    * Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
* It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
* Example 1:
    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]
*
* Approach: Preorder is of the form Root,LeftChild,RightChild.
    * So the first node of the preorder array is root of tree.
    * Now for every element check if that element is less than the root, it will be the left child else the right child.
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
    int preIndex = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,Integer.MAX_VALUE);
    }

    TreeNode constructBST(int[] preOrder,int val){
        if (preIndex==preOrder.length || val<preOrder[preIndex])
            return null;
        TreeNode root=new TreeNode(preOrder[preIndex++]);
        root.left=constructBST(preOrder,root.val);
        root.right=constructBST(preOrder,val);
        return root;
    }
}
