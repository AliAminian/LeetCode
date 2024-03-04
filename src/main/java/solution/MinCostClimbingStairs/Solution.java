package solution.MinCostClimbingStairs;

import java.util.ArrayList;
import java.util.List;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        if (cost.length == 3) return Math.min(cost[0]+cost[2], cost[1]);

        List<Integer> arr = new ArrayList<>();

        arr.add(cost[0]);
        arr.add(Math.min(cost[1], cost[0]));

        for (int i = 2; i < cost.length; i++) {
            if (cost[i-2] < cost[i-1]) {
                arr.add(cost[i-2] + cost[i]);
            } else {
                arr.add(cost[i-1] + cost[i]);
            }
        }
        return arr.get(arr.size()-1);
    }
}
