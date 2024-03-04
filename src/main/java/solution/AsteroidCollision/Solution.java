package solution.AsteroidCollision;

import java.util.*;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<Integer> resn = sol.getTotalExecutionTime(
                3, List.of(new String[]{
                        "0:start:0",
                        "0:end:4",
                        "0:start:5",
                        "0:end:10"})
        );
        resn.stream().forEach(System.out::println);
    }


    public List<Integer> getTotalExecutionTime(int n, List<String> logs) {
        // Write your code here
        Stack<String> execStack = new Stack<>();
        Map<Integer, Integer> durMap = new HashMap<>();

        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            String[] params = log.split(":");

            if (log.contains("start")) {
                execStack.push(log);
            } else {
                if (execStack.isEmpty()) break;
                String[] tmp = execStack.pop().split(":");
                int dur = Integer.valueOf(params[2]) - Integer.valueOf(tmp[2]);
                int id = Integer.valueOf(params[0]);
                if (!durMap.containsKey(id)) {
                    durMap.put(id, dur);
                } else {
                    durMap.put(id, durMap.get(id)+dur);
                }
            }
        }
        return new ArrayList<Integer>(durMap.values());
    }

}

