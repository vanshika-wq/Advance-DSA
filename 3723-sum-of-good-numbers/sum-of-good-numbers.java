class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            
            if (i - k >= 0 && nums[i] <= nums[i - k]) ok = false;
            if (i + k < n && nums[i] <= nums[i + k]) ok = false;
            
            if (ok) sum += nums[i];
        }
        
        return sum;
    }
}