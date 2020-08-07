/*
* Given a binary tree, return the vertical order traversal of its nodes values.
* For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
* Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes,
* we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
* If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
* Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
* Example 1:
    Input: [3,9,20,null,null,15,7]
    Output: [[9],[3,15],[20],[7]]
    Explanation:
        Without loss of generality, we can assume the root node is at position (0, 0):
        Then, the node with value 9 occurs at position (-1, -1);
        The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
        The node with value 20 occurs at position (1, -1);
        The node with value 7 occurs at position (2, -2).
* Example 2:
    Input: [1,2,3,4,5,6,7]
    Output: [[4],[2],[1,5,6],[3],[7]]
    Explanation:
    The node with value 5 and the node with value 6 have the same position according to the given scheme.
    However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
* Note:
    The tree will have between 1 and 1000 nodes.
    Each node's value will be between 0 and 1000.
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

class Node{
    TreeNode treeNode;
    int index;

    public Node(TreeNode node, int index){
        this.treeNode = node;
        this.index = index;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        levelOrderTraversal(map, root);
        result.addAll(map.values());
        return result;
    }

    public void levelOrderTraversal(Map<Integer, List<Integer>> map, TreeNode root){
        if(root==null)
            return;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0));

        while(!queue.isEmpty()){
            int size = queue.size();
            Map<Integer, TreeSet<Integer>> tempResult = new HashMap();
            while(size-->0){
                Node n = queue.poll();
                TreeSet<Integer> list = tempResult.getOrDefault(n.index, new TreeSet<Integer>());
                list.add(n.treeNode.val);
                tempResult.put(n.index, list);
                if(n.treeNode.left!=null)
                    queue.add(new Node(n.treeNode.left, n.index-1));

                if(n.treeNode.right!=null)
                    queue.add(new Node(n.treeNode.right, n.index+1));
            }
            for(int i: tempResult.keySet()){
                List<Integer> list = map.getOrDefault(i, new ArrayList<Integer>());
                list.addAll(tempResult.get(i));
                map.put(i, list);
            }
        }
    }
}
