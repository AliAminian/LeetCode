package solution.StringCompression;


/**
 * Given an array of characters chars, compress it using the following algorithm:
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * If the group's length is 1, append the character to s.
 * Otherwise, append the character followed by the group's length.
 * The compressed string s should not be returned separately, but instead, be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] in = new char[] {'a','a','a','a','a','a','b','b','b','b','b','b','b','b','b','b','b','b','b',
                'b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c'};
        int i = sol.compress(in);
        System.out.println(in);
    }

    public int compress(char[] chars) {
        int cnt = 1, index = 0;
        char prev = ' ';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != prev) {

                if (cnt > 1) {
                    char[] arr = Integer.valueOf(cnt).toString().toCharArray();
                    for (int j = 0; j < arr.length; j++)
                        chars[index+j] = arr[j];
                    index = index + arr.length;
                    cnt = 1;
                }
                chars[index] = chars[i];
                prev = chars[i];
                index++;
            } else if (chars[i] == prev) {
                cnt++;
            }
            if(i == chars.length-1 && cnt > 1) {
                char[] arr = Integer.valueOf(cnt).toString().toCharArray();
                for (int j = 0; j < arr.length; j++)
                    chars[index+j] = arr[j];
                index = index + arr.length;
            }
        }

        return index;
    }
}
