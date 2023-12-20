package solution.FindtheDifferenceofTwoArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> res = sol.findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2});
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();

        for (int n: nums1) n1.add(n);
        for (int n: nums2) n2.add(n);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (Integer n: n1) {
            if (!n2.contains(n))
                res.get(0).add(n);
        }

        for (Integer n: n2) {
            if (!n1.contains(n))
                res.get(1).add(n);
        }
        return res;
    }
}
