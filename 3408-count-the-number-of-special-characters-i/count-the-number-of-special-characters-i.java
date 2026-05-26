import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }
        
        int count = 0;
        for (char ch : lower) {
            if (upper.contains(Character.toUpperCase(ch))) {
                count++;
            }
        }
        
        return count;
    }
}