import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> indexMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if (indexMap.containsKey(c)) {
                start = Math.max(indexMap.get(c) + 1, start);
            }
            indexMap.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String test = "abcabcbb";
        int result = sol.lengthOfLongestSubstring(test);
        System.out.println("Longest substring length: " + result);
    }
}
