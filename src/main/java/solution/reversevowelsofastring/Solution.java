package solution.reversevowelsofastring;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseVowels("heAllO"));
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Character> vow = new HashMap<>();
        vow.put('a', 'a');
        vow.put('e', 'e');
        vow.put('i', 'i');
        vow.put('o', 'o');
        vow.put('u', 'u');
        vow.put('A', 'a');
        vow.put('E', 'e');
        vow.put('I', 'i');
        vow.put('O', 'o');
        vow.put('U', 'u');
        int i = 0;
        int j = arr.length-1;
        while(i < j) {
            while(i < arr.length) {
                if (vow.containsKey(arr[i])) break;
                i++;
            }
            while(j >= 0) {
                if (vow.containsKey(arr[j])) break;
                j--;
            }
            if (i < j) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
            j--;
        }
        return new String(arr);
    }
}
