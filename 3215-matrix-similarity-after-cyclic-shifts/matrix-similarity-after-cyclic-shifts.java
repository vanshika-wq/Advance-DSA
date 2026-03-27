class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        
        for (int i = 0; i < m; i++) {
            int shift = k % n;
            
            for (int j = 0; j < n; j++) {
                int newCol;
                
                if (i % 2 == 0) {
                    newCol = (j + shift) % n;
                } else {
                    newCol = (j - shift + n) % n;
                }
                
                if (mat[i][j] != mat[i][newCol]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}