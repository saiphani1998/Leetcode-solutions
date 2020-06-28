/*
* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
* All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
* Note: If there are multiple valid itineraries,
    you should return the itinerary that has the smallest lexical order when read as a single string.
    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
    All airports are represented by three capital letters (IATA code).
    You may assume all tickets form at least one valid itinerary.
    One must use all the tickets once and only once.
* Example 1:
    Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
    Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
* Example 2:
    Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
        But it is larger in lexical order.
* */

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return result;
        }
        Map<String, List<String>> adjList = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (adjList.containsKey(from)) {
                adjList.get(from).add(to);
            } else {
                List<String> neighbors = new ArrayList<>();
                neighbors.add(to);
                adjList.put(from, neighbors);
            }
        }

        for (String from : adjList.keySet()) {
            List<String> neighbors = adjList.get(from);
            Collections.sort(neighbors);
        }

        findItineraryHelper("JFK", adjList, result);

        return result;
    }

    private void findItineraryHelper(String curr, Map<String, List<String>> adjList, List<String> result) {

        List<String> neighbors = adjList.get(curr);

        if (neighbors != null) {
            while (neighbors.size() > 0) {
                String neighbor = neighbors.get(0);
                neighbors.remove(0);
                findItineraryHelper(neighbor, adjList, result);
            }
        }

        result.add(0, curr);
    }
}
