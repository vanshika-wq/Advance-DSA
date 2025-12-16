class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        
        while (n > 0) {
            n--;  // Convert to 0-indexed (A=0, B=1, ..., Z=25)
            result.append((char)('A' + n % 26));
            n /= 26;
        }
        
        return result.reverse().toString();
    }
}
