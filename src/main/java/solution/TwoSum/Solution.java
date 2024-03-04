package solution.TwoSum;

import java.util.*;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.twoSum(new int[]{3,2,4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                List<Integer> arr = new ArrayList(map.get(curr));
                arr.add(i);
                map.put(curr, arr);
            } else {
                map.put(curr, Arrays.asList(i));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target-nums[i];
            if (map.containsKey(other)) {
                List<Integer> arr = map.get(other);
                for (Integer t: arr)
                    if (t != i)
                        return new int[]{i, t};
                return new int[]{};
            }
        }
        return new int[]{};
    }
}
