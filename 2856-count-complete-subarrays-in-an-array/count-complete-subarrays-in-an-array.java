import java.util.HashSet;

class Solution {

    public int countCompleteSubarrays(int[] nums) {

        int n = nums.length;

        HashSet<Integer> unique = new HashSet<>();

        for (int i = 0; i < n; i++) {
            unique.add(nums[i]);
        }

        int totalUnique = unique.size();
        int answer = 0;

        for (int i = 0; i < n; i++) {

            HashSet<Integer> current = new HashSet<>();

            for (int j = i; j < n; j++) {

                current.add(nums[j]);

                if (current.size() == totalUnique) {
                    answer++;
                }
            }
        }

        return answer;
    }
}