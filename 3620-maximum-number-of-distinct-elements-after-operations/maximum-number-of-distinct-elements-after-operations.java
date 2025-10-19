import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long current = Long.MIN_VALUE; // tracks the next available smallest unused number
        int distinctCount = 0;

        for (int num : nums) {
            long left = (long) num - k;
            long right = (long) num + k;

            // If current is before the possible range, start from left
            if (current < left) {
                current = left;
            }

            // If current still within the valid range, use it
            if (current <= right) {
                distinctCount++;
                current++; // move to next available unique number
            }
        }

        return distinctCount;
    }
}
