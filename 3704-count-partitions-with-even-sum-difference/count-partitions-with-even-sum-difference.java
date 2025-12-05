class Solution {
    public int countPartitions(int[] nums) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if ((sum & 1L) == 1L) {
            return 0;
        }
        return nums.length - 1;
    }
}
