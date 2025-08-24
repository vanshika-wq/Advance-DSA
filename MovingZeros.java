import java.util.*;

public class MovingZeros {

    // Function to move zeros to the end
    public static void moveZeroes(int[] nums) {
        int index = 0;  // position to place next non-zero

        // Step 1: Move all non-zeros forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Step 2: Fill remaining with zeros
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    // Main for VS Code testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int nums[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        moveZeroes(nums);

        System.out.println("Array after moving zeros: " + Arrays.toString(nums));
    }
}
