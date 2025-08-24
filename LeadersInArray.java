import java.util.*;

public class LeadersInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        List<Integer> leaders = new ArrayList<>();

        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);   // rightmost element is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }

        Collections.reverse(leaders);
        System.out.println("Leaders in array: " + leaders);
    }
}
