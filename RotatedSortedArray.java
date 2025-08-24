import java.util.*;

public class RotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sk.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements of rotated sorted array:");
        for (int i = 0; i < n; i++) nums[i] = sk.nextInt();

        System.out.print("Enter target to search: ");
        int target = sk.nextInt();

        int index = search(nums, target);
        System.out.println("Target found at index: " + index);
    }
}
