import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        
        if (s.charAt(n - 1) == '1') {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int max_reached = 0;

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (i == n - 1) {
                return true;
            }

            int start = Math.max(i + minJump, max_reached + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    queue.add(j);
                }
            }

            max_reached = Math.max(max_reached, i + maxJump);
        }

        return false;
    }
}