class Solution {
    public static int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer [n];
        if(n == 0){
            return -1;
        }
        return solve (0, nums, dp);   
    }

    private static int solve(int i , int [] nums, Integer[] dp){
        int n = nums.length;
        if (i >= n) return 0;
        
        if (dp[i] != null) return dp[i];

        int steal = nums[i] + solve (i+2,nums,dp);
        int skip = solve (i+1,nums,dp);
        
        
        dp[i] = Math.max(steal,skip);
         
        return dp [i];
    }

    public static void main(String[] args){
        int[] nums = { };
        System.out.println(rob(nums));
    }

}