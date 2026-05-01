class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long totalSum = 0, F = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            F += (long) i * nums[i];
        }

        long maxVal = F;

        for (int k = 1; k < n; k++) {
            F = F + totalSum - (long) n * nums[n - k];
            maxVal = Math.max(maxVal, F);
        }

        return (int) maxVal;
    }
}