class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);  
        long sum = 0;
        for (int i = 0; i < k; i++) {
            
            long val = Math.max(0, (long)happiness[happiness.length - 1 - i] - i);
            sum += val;
        }
        return sum;
    }
}
