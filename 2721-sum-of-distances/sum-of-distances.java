import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long ans[] = new long[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);

            int m = list.size();
            long prefix[] = new long[m];

            prefix[0] = list.get(0);
            for (int i = 1; i < m; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for (int i = 0; i < m; i++) {
                int idx = list.get(i);

                long left = (long)i * idx - (i > 0 ? prefix[i - 1] : 0);
                long right = (prefix[m - 1] - prefix[i]) - (long)(m - i - 1) * idx;

                ans[idx] = left + right;
            }
        }

        return ans;
    }
}