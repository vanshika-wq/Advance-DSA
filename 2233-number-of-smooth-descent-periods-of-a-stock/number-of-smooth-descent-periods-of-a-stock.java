class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int len = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i-1] - 1) {
                len++;
            } else {
                ans += (long) len * (len + 1) / 2;
                len = 1;
            }
        }
        ans += (long) len * (len + 1) / 2;  // Don't forget last sequence
        return ans;
    }
}
