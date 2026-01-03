class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        // If array is not rotated, first element is minimum
        if (nums[left] <= nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum lies in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Minimum lies in the left half (including mid)
                right = mid;
            }
        }

        // left == right -> index of minimum
        return nums[left];
    }
}
