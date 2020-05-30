/*
* There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
* Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
* Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
* Example 1:
    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0. So it is possible.
* Example 2:
    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
        To take course 1 you should have finished course 0, and to take course 0 you should
        also have finished course 1. So it is impossible.
*
* Approach: This problem is equivalent to finding if a cycle exists in a directed graph.
    * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
* */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (adjList.containsKey(edge[0])) {
                List<Integer> neighbors = adjList.get(edge[0]);
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            }
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, visited, adjList)) {
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[vertexId] == -1) {
            return true;
        }
        if (visited[vertexId] == 1) {
            return false;
        }
        visited[vertexId] = -1;
        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCycle(neighbor, visited, adjList)) {
                    return true;
                }
            }
        }
        visited[vertexId] = 1;
        return false;
    }
}
