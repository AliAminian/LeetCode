package solution.canplaceflowers;
/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
 * planted in adjacent plots. Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1
 * means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating
 * the no-adjacent-flowers rule and false otherwise.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int counter = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean res = checkIt(flowerbed, i);
            if(res) {
                counter++;
                i++;
            }
        }
        return n<=counter;
    }

    private boolean checkIt(int[] arr, int i) {
        if (i == 0) {
            if (arr.length == 1) return (arr[0] == 0);
            else if (arr.length > 1) return (arr[1] == 0 && arr[0] == 0);
        } else if (i == arr.length-1) return (arr[i] == 0 && arr[i-1] == 0);
        else return (arr[i-1] == 0 && arr[i] == 0 && arr[i+1] == 0);
        return false;
    }
}
