class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Even positions: {0, 2} can be swapped freely
        boolean evenMatch = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2))
                         || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // Odd positions: {1, 3} can be swapped freely
        boolean oddMatch  = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3))
                         || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return evenMatch && oddMatch;
    }
}