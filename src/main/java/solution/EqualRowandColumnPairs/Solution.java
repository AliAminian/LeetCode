package solution.EqualRowandColumnPairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}});
    }

    public int equalPairs(int[][] grid) {
        Map<String, Integer> mx = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            StringBuffer t = new StringBuffer();

            for (int j = 0; j < grid[0].length; j++)
                t.append(grid[i][j] + "-");

            String str = t.toString();
            if (mx.containsKey(str))
                mx.put(str,mx.get(str)+1);
            else
                mx.put(str,1);
        }

        List<String> cols = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuffer t = new StringBuffer();
            for (int j = 0; j < grid[0].length; j++)
                t.append(grid[j][i] + "-");
            cols.add(t.toString());
        }

        int count = 0;
        for (String s: cols)
            if (mx.containsKey(s))
                count += mx.get(s);

        return count;
    }
}
