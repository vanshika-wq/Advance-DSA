class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 1;
        long high = (long)1e18;

        while (low < high) {
            long mid = (low + high) / 2;
            long total = 0;

            for (int t : workerTimes) {
                long k = (long)((Math.sqrt(1 + 8.0 * (mid / (double)t)) - 1) / 2);
                total += k;
                if (total >= mountainHeight) break;
            }

            if (total >= mountainHeight) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}