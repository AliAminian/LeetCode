package solution.Sublists;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> pairs = List.of(List.of(1,2), List.of(2,3), List.of(4,5), List.of(3,6), List.of(5,7), List.of(8,9));
        List<List<Integer>> result = getSublists(pairs);
        System.out.println("hi");
    }

    public static List<List<Integer>> getSublists(List<List<Integer>> pairs) {

        // create adjacency map
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (List<Integer> pair: pairs) {
            adjMap.putIfAbsent(pair.get(0), new ArrayList<>());
            adjMap.putIfAbsent(pair.get(1), new ArrayList<>());
            adjMap.get(pair.get(0)).add(pair.get(1));
            adjMap.get(pair.get(1)).add(pair.get(0));
        }

        List<List<Integer>> result = new ArrayList<>();

        // dfs iterate
        Set<Integer> visited = new HashSet<>();
        for (Integer node: adjMap.keySet()) {
            if (!visited.contains(node)) {
                List<Integer> sublist = bfs(adjMap, visited, node, new ArrayList<>());
                if (sublist != null && !sublist.isEmpty())
                    result.add(sublist);
            }
        }
        return result;
    }

    public static List<Integer> bfs(Map<Integer, List<Integer>> connections, Set<Integer> visited, Integer node, List<Integer> currentList) {
        if (visited.contains(node)) return currentList;

        currentList.add(node);
        visited.add(node);
        for (Integer connection: connections.get(node)) {
            bfs(connections, visited, connection, currentList);
        }
        return currentList;
    }
}
