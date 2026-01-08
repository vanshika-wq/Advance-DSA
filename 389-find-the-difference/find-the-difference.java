class Solution {
    public char findTheDifference(String s, String t) {
        int xor = 0;

        // XOR all chars of s
        for (int i = 0; i < s.length(); i++) {
            xor ^= s.charAt(i);
        }

        // XOR all chars of t
        for (int i = 0; i < t.length(); i++) {
            xor ^= t.charAt(i);
        }

        // remaining value is the extra char in t
        return (char) xor;
    }
}
