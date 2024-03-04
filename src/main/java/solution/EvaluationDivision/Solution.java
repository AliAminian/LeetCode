package solution.EvaluationDivision;

import java.util.*;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> equations = List.of(List.of("a","b"),List.of("b","c"));
        double[] values = {2.0, 3.0};
        List<List<String>> querie = List.of(List.of("b","a"),List.of("c","b"),List.of("bc","cd"), List.of("cd","bc"));

        double[] res = sol.calcEquation(equations, values, querie);

        Arrays.stream(res).forEach(System.out::println);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> adj = new HashMap<>();

        // Create adj list
        for (int i = 0 ; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            adj.putIfAbsent(eq.get(0), new HashMap<String, Double>());
            adj.putIfAbsent(eq.get(1), new HashMap<String, Double>());
            adj.get(eq.get(0)).put(eq.get(1), values[i]);
            adj.get(eq.get(1)).put(eq.get(0), 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0 ; i < queries.size(); i++) {
            if (!adj.containsKey(queries.get(i).get(0)) || !adj.containsKey(queries.get(i).get(1))) {
                res[i] = -1;
                continue;
            }
            res[i] = dfs(adj, queries.get(i).get(0), queries.get(i).get(1), 1.0, new HashSet<>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> adj, String from, String to, double currentVal, Set<String> visitedList) {

        //if (visitedList.contains(from)) return currentVal;
        if (from.equals(to)) return 1.0;
        visitedList.add(from);

        for (Map.Entry<String, Double> neigh: adj.get(from).entrySet()) {
            if (visitedList.contains(neigh.getKey()))
                continue;
            double tmp = dfs(adj, neigh.getKey(), to, neigh.getValue() * currentVal, visitedList);
            if (tmp > 0)
                return neigh.getValue() * tmp;
        }

        return -1.0;
    }
}
