public class minimum {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        minimum obj = new minimum();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element: " + obj.findMin(nums));
    }
}
