class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        final int INF = Integer.MAX_VALUE;
        int min1 = INF, min11 = INF;
        int min2 = INF, min22 = INF;

        for (int num : nums) {
            sum += num;
            int r = num % 3;
            if (r < 0) r += 3; 

            if (r == 1) {
               
                if (num < min1) {
                    min11 = min1;
                    min1 = num;
                } else if (num < min11) {
                    min11 = num;
                }
            } else if (r == 2) {
               
                if (num < min2) {
                    min22 = min2;
                    min2 = num;
                } else if (num < min22) {
                    min22 = num;
                }
            }
        }

        if (sum % 3 == 0) return sum;

        int removal = INF;

        if (sum % 3 == 1) {
            
            if (min1 != INF) removal = Math.min(removal, min1);
            // Option B: remove two smallest remainder-2 numbers (if both exist)
            if (min2 != INF && min22 != INF) {
                // safe to add because both are real values (not INF)
                removal = Math.min(removal, min2 + min22);
            }
        } else { // sum % 3 == 2
            // Option A: remove one smallest remainder-2 number (if exists)
            if (min2 != INF) removal = Math.min(removal, min2);
            // Option B: remove two smallest remainder-1 numbers (if both exist)
            if (min1 != INF && min11 != INF) {
                removal = Math.min(removal, min1 + min11);
            }
        }

        if (removal == INF) {
            // No valid removal combination -> can't form divisible sum -> return 0
            return 0;
        }

        return sum - removal;
    }
}