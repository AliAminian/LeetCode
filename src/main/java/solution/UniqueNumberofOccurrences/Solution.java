package solution.UniqueNumberofOccurrences;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));
    }

    /*
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) map.merge(i, 1, Integer::sum);
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
    */
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n: arr)
            if (map.containsKey(n))
                map.put(n, map.get(n)+1);
            else
                map.put(n, 1);

        HashSet<Integer> set = new HashSet<>();
        boolean res = true;
        for (Map.Entry e: map.entrySet()) {
            if (!set.add((Integer) e.getValue()))
                return false;
        }
        return true;
    }
}
