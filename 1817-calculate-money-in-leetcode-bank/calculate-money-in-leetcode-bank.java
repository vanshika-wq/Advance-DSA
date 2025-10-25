class Solution {
    public int totalMoney(int n) {
        int week = n / 7;
        int day = n % 7;
        int totalWeeks = (28 + 28 + 7 * (week - 1)) * week / 2;
        int totalDays = (day * (2 * week + day + 1)) / 2;
        return totalWeeks + totalDays;
    }
}
