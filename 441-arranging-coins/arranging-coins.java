class Solution {
    public int arrangeCoins(int n) {
    
        long nn = n;
        long k = (long)((-1 + Math.sqrt(1 + 8.0 * nn)) / 2.0);
        return (int) k;
    }
}
