package solution.KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

/**
 *There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of
 * candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
 * they will have the greatest number of candies among all the kids, or false otherwise.
 * Note that multiple kids can have the greatest number of candies.
 */
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kidsWithCandies(new int[]{2,3,5,1,3}, 3));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            if (candy > max) max = candy;
        }
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                res.add(true);
                continue;
            }
            res.add(false);
        }
        return res;
    }
}
