package solution.CurrencyExchanger;

import java.util.*;
public class CurrencyConverter {
    public static List<Double> calculateConversionRates(List<Object[]> rates, List<Object[]> queries) {
        List<Double> res = new ArrayList<>();

        Map<String, Map<String, Double>> graph= new HashMap<>();

        // create adj_list
        for (Object[] rate: rates) {
            String from = (String) rate[0];
            String to = (String) rate[1];
            double rat = (double) rate[2];
            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(from).put(to, rat);
            graph.get(to).put(from, 1/rat);
        }

        // dfs
        for (Object[] query: queries) {
            String from = (String) query[0];
            String to = (String) query[1];
            Set<String> visited = new HashSet<>();
            double rate = dfs(graph, from, to, 1.0,visited);
            res.add(rate);
        }

        return res;
    }

    public static double dfs(Map<String, Map<String, Double>> graph, String from, String to, Double value, Set<String> visited) {
        if (!graph.containsKey(from) || visited.contains(from)) return -1.0;
        if (from.equals(to)) return value;

        visited.add(from);

        Map<String, Double> neighbors = graph.get(from);
        for(String n : neighbors.keySet()) {
            double tmp_val = neighbors.get(n);
            double tmp_rate = dfs(graph, n, to, value*tmp_val, visited);
            if (tmp_rate != -1.0) {
                return tmp_rate;
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        List<Object[]> rates = new ArrayList<>();
        rates.add(new Object[]{"USD", "JPY", 100.0});
        rates.add(new Object[]{"JPY", "CHN", 20.0});
        rates.add(new Object[]{"CHN", "THAI", 200.0});

        List<Object[]> queries = new ArrayList<>();
        queries.add(new Object[]{"USD", "CHN"});
        queries.add(new Object[]{"JPY", "THAI"});
        queries.add(new Object[]{"USD", "AUD"});

        List<Double> results = calculateConversionRates(rates, queries);
        System.out.println(results); // prints [1000.0, 4000.0, -1.0]
    }
}
