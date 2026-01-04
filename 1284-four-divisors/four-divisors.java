class Solution {
    public int sumFourDivisors(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += getDivisorSum(num);
        }
        return total;
    }
    
    private int getDivisorSum(int n) {
        int count = 2;
        int sum = n + 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                sum += i;
                if (i * i != n) {
                    count++;
                    sum += n / i;
                }
            }
        }
        return count == 4 ? sum : 0;
    }
}
