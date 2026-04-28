class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int direct = Math.abs(i - startIndex);
                int circular = n - direct;
                min = Math.min(min, Math.min(direct, circular));
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}