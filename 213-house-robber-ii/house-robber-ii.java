class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        return Math.max(robRange(nums, 0, n-2), robRange(nums, 1, n-1));
    }
    
    private int robRange(int[] nums, int start, int end) {
        int pick = 0;   
        int notPick = 0; 
        
        for (int i = start; i <= end; i++) {
            int take = nums[i] + pick;
            int skip = notPick;
            int currMax = Math.max(take, skip);
            
            pick = notPick;
            notPick = currMax;
        }
        return notPick;
    }
}
