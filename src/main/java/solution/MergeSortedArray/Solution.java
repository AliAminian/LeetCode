package solution.MergeSortedArray;
/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.merge(new int[]{4,0,0,0,0,0}, 1, new int[]{1,2,3,5,6}, 5);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[i+m] = nums2[i];

        for (int i = 0; i < m+n; i++) {
            int min = i;
            for (int j = i+1; j < n+m; j++) {
                if (nums1[min] > nums1[j])
                    min = j;
            }

            int tmp = nums1[i];
            nums1[i] = nums1[min];
            nums1[min] = tmp;
        }
    }
}
