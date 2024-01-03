package solution.AsteroidCollision;

import java.util.Arrays;
import java.util.Stack;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] resn = sol.asteroidCollision(new int[]{1,1,-1,-2});
        Arrays.stream(resn).forEach(System.out::println);
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> as = new Stack<>();
        int prev = -1001;
        for (int el: asteroids) {
            if (el > 0) {
                as.push(el);
            } else if (el < 0) { // Collision
                if (Math.abs(el) == Math.abs(prev)) {
                    as.pop();
                    as.pop();
                    if (!as.isEmpty()) {
                        prev = as.peek();
                        continue;
                    }
                } else {
                    while(el < 0 && prev > 0 && !as.isEmpty()) {
                        el = as.pop();
                        if (as.isEmpty()) {
                            as.push(el);
                            break;
                        }
                        prev = as.pop();
                        el = collide(prev, el);
                        if (el == -1001) {
                            prev = el;
                            continue;
                        }
                        if (!as.isEmpty()) prev = as.peek();
                        as.push(el);
                    }
                }
            }
            prev = el;
        }
        Object[] arr = as.toArray();
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) res[i] = (Integer)arr[i];
        return res;
    }

    private int collide(int prev , int cur) {
        if (Math.abs(prev) == Math.abs(cur)) return -1001;
        return (Math.abs(prev) > Math.abs(cur))? prev: cur;
    }
}
