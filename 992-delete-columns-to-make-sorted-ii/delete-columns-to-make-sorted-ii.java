class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        if (n <= 1) return 0;
        
        int m = strs[0].length();
        boolean[] sorted = new boolean[n - 1]; // Tracks if adjacent pairs are confirmed sorted
        int deletions = 0;
        
        for (int col = 0; col < m; col++) {
            boolean deleteCol = false;
            // Check if this column violates any undecided pair
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    deleteCol = true;
                    break; // Column must be deleted
                }
            }
            if (deleteCol) {
                deletions++;
                continue; // Skip cut updates for deleted column
            }
            // Column kept: update sorted pairs where strictly increasing
            for (int row = 0; row < n - 1; row++) {
                if (!sorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }
        return deletions;
    }
}
