/*
* Given a directed, acyclic graph of N nodes.
* Find all possible paths from node 0 to node N-1, and return them in any order.
* The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
* graph[i] is a list of all nodes j for which the edge (i, j) exists.

* Example:
    Input: [[1,2], [3], [3], []]
    Output: [[0,1,3],[0,2,3]]
    Explanation: The graph looks like this:
        0--->1
        |    |
        v    v
        2--->3
    There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

* Note:
    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.
* */

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        getPaths(result, list, graph, 0);
        return result;
    }
    private void getPaths(List<List<Integer>> result, List<Integer> list, int[][] graph, int st) {
        if (st == graph.length -1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < graph[st].length; i++) {
            list.add(graph[st][i]);
            getPaths(result, list, graph, graph[st][i]);
            list.remove(list.size() - 1);
        }
    }
}
