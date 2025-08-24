import java.util.*;

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) nums[++i] = nums[j];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sk = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sk.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " sorted elements:");
        for (int i = 0; i < n; i++) nums[i] = sk.nextInt();

        int k = removeDuplicates(nums);

        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < k; i++) System.out.print(nums[i] + " ");
    }
}
