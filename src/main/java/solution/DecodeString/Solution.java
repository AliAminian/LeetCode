package solution.DecodeString;

import java.util.Stack;

/**
 * The problem
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("3[a]2[bc]")); //3[a2[c]]]
    }

    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();

        StringBuilder str = new StringBuilder();

        int num = 0;

        for(char c: s.toCharArray()) {
            if ( '0' <= c && c <= '9') num = 10*num + (c-'0');
            else if (c == '[') { // terminate everything and reset
                strings.push(str.toString());
                numbers.push(num);

                str.setLength(0);
                num = 0;
            } else if (c == ']') { // to decode
                int cnt = numbers.pop();
                String mainStr = str.toString();
                while (cnt > 1) {
                    str.append(mainStr);
                    cnt--;
                }
            } else str.append(c);
        }
        return str.toString();
    }
}
