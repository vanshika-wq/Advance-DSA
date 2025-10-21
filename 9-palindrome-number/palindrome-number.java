class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and multiples of 10 (except 0) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }

        // Compare first half and reversed second half
        return (x == reversedHalf || x == reversedHalf / 10);
    }
}
