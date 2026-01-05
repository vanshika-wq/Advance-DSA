class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int minAbsValue = Integer.MAX_VALUE;
        int negativeCount = 0;
        
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < 0) {
                    negativeCount++;
                }
                int absValue = Math.abs(element);
                totalSum += absValue;
                minAbsValue = Math.min(minAbsValue, absValue);
            }
        }
        
        if (negativeCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2L * minAbsValue;
        }
    }
}
